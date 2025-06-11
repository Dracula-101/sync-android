package com.android.sync.core.network.util

import com.android.sync.core.network.model.SyncError
import retrofit2.HttpException
import java.io.IOException

/**
 * Convert a [Throwable] into a [SyncError].
 */
fun Throwable.toSyncError(): SyncError {
    return when (this) {
        is IOException -> SyncError.Network(this)
        is HttpException -> {
            // For HttpException, we need to parse the response body to get the error details
            // This will be handled in the NetworkResponseCall where we have access to Gson
            SyncError.Http(
                throwable = this,
                message = "HTTP ${code()} error",
                errors = null
            )
        }

        else -> SyncError.Other(this)
    }
}