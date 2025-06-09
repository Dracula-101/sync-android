package com.android.sync.core.network.model

import com.android.sync.core.network.interceptor.AuthTokenProvider

data class SyncClientConfig(
    val baseUrl: String,
    val httpBodyLogging: Boolean,
)