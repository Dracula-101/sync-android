package com.android.sync.core.network.model

import retrofit2.HttpException
import java.io.IOException

/**
 * Represents different types of errors that can occur in the Sync application.
 */
sealed class SyncError {
    /**
     * An abstract property that holds the underlying throwable that caused the error.
     */
    abstract val throwable: Throwable

    /**
     * Errors related to HTTP requests and responses.
     */
    data class Http(override val throwable: HttpException) : SyncError() {
        /**
         * The error code of the HTTP response.
         */
        val code: Int get() = throwable.code()

        /**
         * The response body of the HTTP response.
         */
        val responseBodyString: String? by lazy {
            throwable.response()?.errorBody()?.string()
        }
    }

    /**
     * Errors related to network.
     */
    data class Network(override val throwable: IOException) : SyncError()

    /**
     * Other types of errors not covered by any special cases.
     */
    data class Other(override val throwable: Throwable) : SyncError()
}

/**
 * Convert a [Throwable] into a [SyncError].
 */
fun Throwable.toSyncError(): SyncError {
    return when (this) {
        is IOException -> SyncError.Network(this)
        is HttpException -> SyncError.Http(this)
        else -> SyncError.Other(this)
    }
}
