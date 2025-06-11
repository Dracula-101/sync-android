package com.android.sync.core.network.core

import com.android.sync.core.network.model.NetworkResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * A [CallAdapter.Factory] for wrapping network requests into [NetworkResponse].
 */
class NetworkResponseCallAdapterFactory(
    private val gson: Gson
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        check(returnType is ParameterizedType) { "$returnType must be parameterized" }
        val containerType = getParameterUpperBound(0, returnType)

        if (getRawType(containerType) != NetworkResponse::class.java) return null
        check(containerType is ParameterizedType) { "$containerType must be parameterized" }

        val requestType = getParameterUpperBound(0, containerType)

        return if (getRawType(returnType) == Call::class.java) {
            NetworkResponseCallAdapter<Any>(successType = requestType, gson = gson)
        } else {
            null
        }
    }
}