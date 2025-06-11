package com.application.sync.core.network.model

// Meta information common to both success and error responses
data class Meta(
    val success: Boolean,
    val statusCode: Int,
    val timestamp: String
)