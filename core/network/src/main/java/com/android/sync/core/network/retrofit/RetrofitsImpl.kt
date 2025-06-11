package com.android.sync.core.network.retrofit

import com.android.sync.core.network.core.NetworkResponseCallAdapterFactory
import com.android.sync.core.network.interceptor.HeadersInterceptor
import com.android.sync.core.network.util.HEADER_AUTHORIZATION
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * Primary implementation of [Retrofits].
 */
internal class RetrofitsImpl(
    private val baseUrl: String,
    private val gson: Gson,
    private val headersInterceptor: HeadersInterceptor,
    private val logHttpBody: Boolean = false,
) : Retrofits {

    override val auth: Retrofit by lazy {
        // Create a Retrofit instance for auth routes like login, register, etc.
        // which don't require access token
        createUnauthenticatedRetrofit()
    }

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor { message -> Timber.tag("SyncNetworkClient").d("[NETWORK] $message") }
            .apply {
                redactHeader(name = HEADER_AUTHORIZATION)
                setLevel(
                    level = HttpLoggingInterceptor.Level.BODY
                        .takeIf { logHttpBody }
                        ?: HttpLoggingInterceptor.Level.BASIC,
                )
            }
    }

    private val baseOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headersInterceptor)
        .build()

//    private val authenticatedOkHttpClient: OkHttpClient by lazy {
//        baseOkHttpClient
//            .newBuilder()
//            .addInterceptor(authTokenInterceptor)
//            .build()
//    }

    private val baseRetrofit: Retrofit by lazy {
        baseRetrofitBuilder
            .baseUrl(baseUrl)
            .build()
    }

    private val baseRetrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseCallAdapterFactory(gson))
            .client(baseOkHttpClient)
    }

//    private fun createAuthenticatedRetrofit(): Retrofit =
//        baseRetrofit
//            .newBuilder()
//            .client(
//                authenticatedOkHttpClient
//                    .newBuilder()
//                    .addInterceptor(loggingInterceptor)
//                    .build(),
//            )
//            .build()

    private fun createUnauthenticatedRetrofit(): Retrofit =
        baseRetrofit
            .newBuilder()
            .client(
                baseOkHttpClient
                    .newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .build(),
            )
            .build()
}
