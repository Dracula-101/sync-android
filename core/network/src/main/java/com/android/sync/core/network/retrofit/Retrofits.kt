package com.android.sync.core.network.retrofit

import retrofit2.Retrofit

/**
 * A collection of various [Retrofit] instances that serve different purposes.
 */
internal interface Retrofits {
    /**
     * Provides a [Retrofit] instance for the authentication API.
     */
    val auth: Retrofit
}
