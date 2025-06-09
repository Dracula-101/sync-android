package com.android.sync.core.network

import com.android.sync.core.network.model.SyncClientConfig
import com.android.sync.core.network.service.AuthService

interface SyncNetworkClient {

    /**
     * Provides a [AuthService] instance for the auth API routes.
     */
    val auth: AuthService
}

fun syncServiceClient(
    config: SyncClientConfig,
): SyncNetworkClient {
    return SyncNetworkClientImpl(config)
}