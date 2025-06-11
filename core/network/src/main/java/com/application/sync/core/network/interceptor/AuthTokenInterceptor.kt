package com.application.sync.core.network.interceptor

import com.application.sync.core.network.util.HEADER_AUTHORIZATION
import com.application.sync.core.network.util.HEADER_BEARER_AUTHORIZATION

internal class AuthTokenInterceptor(
    private val authTokenProvider: AuthTokenProvider
) : okhttp3.Interceptor {

    override fun intercept(chain: okhttp3.Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()
        val authToken = authTokenProvider.getLatestAuthToken()

        val newRequest = if (authToken != null) {
            originalRequest.newBuilder()
                .header(HEADER_AUTHORIZATION, "$HEADER_BEARER_AUTHORIZATION $authToken")
                .build()
        } else {
            throw IllegalStateException("Auth token is null, cannot proceed with request")
        }
        return chain.proceed(newRequest)
    }
}