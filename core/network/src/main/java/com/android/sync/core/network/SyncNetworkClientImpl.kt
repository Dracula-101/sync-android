package com.android.sync.core.network

import com.android.sync.core.network.interceptor.HeadersInterceptor
import com.android.sync.core.network.model.SyncClientConfig
import com.android.sync.core.network.retrofit.Retrofits
import com.android.sync.core.network.retrofit.RetrofitsImpl
import com.android.sync.core.network.service.AuthService
import com.android.sync.core.network.service.AuthServiceImpl
import com.google.gson.GsonBuilder
import retrofit2.create

internal class SyncNetworkClientImpl(
    private val config: SyncClientConfig,
) : SyncNetworkClient {


    private val clientGson = GsonBuilder()
        .serializeNulls()
        .setPrettyPrinting()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .create()

    private val retrofits: Retrofits by lazy {
        RetrofitsImpl(
            baseUrl = config.baseUrl,
            gson = clientGson,
            headersInterceptor = HeadersInterceptor(),
            logHttpBody = config.httpBodyLogging, // Enable logging for debugging purposes
        )
    }

    override val auth: AuthService by lazy {
        AuthServiceImpl(authApi = retrofits.auth.create())
    }
}