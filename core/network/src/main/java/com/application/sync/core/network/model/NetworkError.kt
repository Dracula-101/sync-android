package com.application.sync.core.network.model

// Error details
data class NetworkError(
    val code: String,
    val field: String? = null,
    val message: String,
    val detail: String? = null
)

