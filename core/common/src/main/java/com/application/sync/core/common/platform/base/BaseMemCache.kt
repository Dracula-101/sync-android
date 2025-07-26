package com.application.sync.core.common.platform.base

import kotlinx.serialization.KSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

/**
 * Base class for thread-safe in-memory cache with LRU eviction and TTL support
 */
abstract class BaseMemCache<K, V>(
    private val maxSize: Int = 100,
    private val defaultTtl: Long? = null
) {
    private val cache = LinkedHashMap<K, CacheEntry<V>>(16, 0.75f, true)
    private val lock = ReentrantReadWriteLock()

    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = false
    }

    protected fun get(key: K): V? {
        return lock.read {
            val entry = cache[key] ?: return null

            if (entry.isExpired()) {
                lock.write {
                    cache.remove(key)
                }
                return null
            }

            entry.value
        }
    }

    protected fun put(key: K, value: V) {
        put(key, value, defaultTtl)
    }

    protected fun put(key: K, value: V, ttl: Long?) {
        lock.write {
            val entry = CacheEntry(value, System.currentTimeMillis(), ttl)
            cache[key] = entry

            // LRU eviction
            while (cache.size > maxSize) {
                val eldest = cache.entries.iterator().next()
                cache.remove(eldest.key)
            }
        }
    }

    protected fun remove(key: K): V? {
        return lock.write {
            cache.remove(key)?.value
        }
    }

    protected fun clear() {
        lock.write {
            cache.clear()
        }
    }

    protected fun size(): Int {
        return lock.read {
            cleanupExpiredUnsafe()
            cache.size
        }
    }

    protected fun containsKey(key: K): Boolean {
        return lock.read {
            val entry = cache[key] ?: return false
            if (entry.isExpired()) {
                lock.write {
                    cache.remove(key)
                }
                return false
            }
            true
        }
    }

    protected fun getAllKeys(): Set<K> {
        return lock.read {
            cleanupExpiredUnsafe()
            cache.keys.toSet()
        }
    }

    // ==================== KOTLINX SERIALIZATION SUPPORT ====================

    /**
     * Store serializable object using kotlinx.serialization
     */
    protected inline fun <reified T> putSerializable(key: K, obj: T, ttl: Long? = defaultTtl) {
        try {
            val jsonString = json.encodeToString(obj)
            @Suppress("UNCHECKED_CAST")
            put(key, jsonString as V, ttl)
        } catch (e: Exception) {
            // Handle serialization error
        }
    }

    /**
     * Retrieve and deserialize object using kotlinx.serialization
     */
    protected inline fun <reified T> getSerializable(key: K): T? {
        return try {
            @Suppress("UNCHECKED_CAST")
            val jsonString = get(key) as? String ?: return null
            json.decodeFromString<T>(jsonString)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Store serializable object with custom serializer
     */
    protected fun <T> putSerializable(
        key: K,
        obj: T,
        serializer: KSerializer<T>,
        ttl: Long? = defaultTtl
    ) {
        try {
            val jsonString = json.encodeToString(serializer, obj)
            @Suppress("UNCHECKED_CAST")
            put(key, jsonString as V, ttl)
        } catch (e: Exception) {
            // Handle serialization error
        }
    }

    /**
     * Retrieve and deserialize object with custom serializer
     */
    protected fun <T> getSerializable(key: K, serializer: KSerializer<T>): T? {
        return try {
            @Suppress("UNCHECKED_CAST")
            val jsonString = get(key) as? String ?: return null
            json.decodeFromString(serializer, jsonString)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Store object as JSON string directly
     */
    protected fun putJson(key: K, jsonString: String, ttl: Long? = defaultTtl) {
        @Suppress("UNCHECKED_CAST")
        put(key, jsonString as V, ttl)
    }

    /**
     * Get JSON string directly
     */
    protected fun getJson(key: K): String? {
        @Suppress("UNCHECKED_CAST")
        return get(key) as? String
    }

    private fun cleanupExpiredUnsafe() {
        val iterator = cache.entries.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.value.isExpired()) {
                iterator.remove()
            }
        }
    }
}