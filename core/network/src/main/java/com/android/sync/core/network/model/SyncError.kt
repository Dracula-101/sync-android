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
    data class Http(
        override val throwable: HttpException,
        val message: String,
        val errors: List<NetworkError>? = null
    ) : SyncError() {
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

        /**
         * Get the first error message or fallback to main message
         */
        val errorMessage: String
            get() = errors?.firstOrNull()?.message ?: message

        /**
         * Check if this is a validation error (422)
         */
        val isValidationError: Boolean
            get() = code == 422

        /**
         * Check if this is an authentication error (401)
         */
        val isAuthenticationError: Boolean
            get() = code == 401

        /**
         * Check if this is a server error (5xx)
         */
        val isServerError: Boolean
            get() = code in 500..599

        /**
         * Get validation errors grouped by field
         */
        val validationErrorsByField: Map<String, List<NetworkError>>
            get() = errors?.filter { it.field != null }?.groupBy { it.field!! } ?: emptyMap()
    }

    /**
     * Errors related to network connectivity.
     */
    data class Network(override val throwable: IOException) : SyncError() {
        val message: String
            get() = throwable.message ?: "Network connection error"
    }

    /**
     * Other types of errors not covered by any special cases.
     */
    data class Other(override val throwable: Throwable) : SyncError() {
        val message: String
            get() = throwable.message ?: "Unknown error occurred"
    }
}