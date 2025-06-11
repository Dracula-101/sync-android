package com.application.sync.core.network

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
    return SyncNetworkClientImpl(config)
}