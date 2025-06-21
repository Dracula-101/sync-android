package com.application.sync.core.network

import android.util.Log
import com.application.sync.core.network.model.SyncClientConfig
import com.application.sync.core.network.service.AuthService

interface SyncNetworkClient {

    /**
     * Provides a [AuthService] instance for the auth API routes.
     */
    val auth: AuthService
}

fun syncServiceClient(
    config: SyncClientConfig,
): SyncNetworkClient {
    Log.d("MainActivity", "onCreate called")
    return SyncNetworkClientImpl(config)
}