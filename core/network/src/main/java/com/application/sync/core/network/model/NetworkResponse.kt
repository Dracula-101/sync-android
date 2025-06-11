package com.application.sync.core.network.model

// Base sealed class for Network responses
sealed class NetworkResponse<out T> {
    data class Success<T>(
        val meta: Meta,
        val message: String,
        val data: T
    ) : NetworkResponse<T>()

    data class Error(
        val meta: Meta,
        val error: SyncError,
    ) : NetworkResponse<Nothing>()
}