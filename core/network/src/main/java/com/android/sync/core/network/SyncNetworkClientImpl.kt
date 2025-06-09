package com.android.sync.core.network

import com.android.sync.core.network.interceptor.AuthTokenInterceptor
import com.android.sync.core.network.interceptor.HeadersInterceptor
import com.android.sync.core.network.model.SyncClientConfig
import com.android.sync.core.network.retrofit.Retrofits
import com.android.sync.core.network.retrofit.RetrofitsImpl
import com.android.sync.core.network.service.AuthService
import com.android.sync.core.network.service.AuthServiceImpl
import kotlinx.serialization.json.Json
import retrofit2.create

internal class SyncNetworkClientImpl(
    private val config: SyncClientConfig,
) : SyncNetworkClient {


    private val clientJson = Json {

        // If there are keys returned by the server not modeled by a serializable class,
        // ignore them.
        // This makes additive server changes non-breaking.
        ignoreUnknownKeys = true

        // We allow for nullable values to have keys missing in the JSON response.
        explicitNulls = false

        // Respect model default property values.
        coerceInputValues = true

        classDiscriminator = "type"
    }

    private val retrofits: Retrofits by lazy {
        RetrofitsImpl(
            baseUrl = config.baseUrl,
            json = clientJson,
            headersInterceptor = HeadersInterceptor(),
            logHttpBody = config.httpBodyLogging, // Enable logging for debugging purposes
        )
    }

    override val auth: AuthService by lazy {
        AuthServiceImpl(authApi = retrofits.auth.create())
    }
}