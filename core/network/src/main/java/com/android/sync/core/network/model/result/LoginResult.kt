package com.android.sync.core.network.model.result

import com.android.sync.core.network.model.ValidationFieldError
import com.android.sync.core.network.model.response.User

sealed class LoginResult {

    /**
     * Represents a successful login response.
     */
    data class Success(
        val user: User,
        val accessToken: String,
        val refreshToken: String,
    ) : LoginResult()

    /**
     * Represents a invalid login response due to invalid credentials.
     */
    data class InvalidCredentials(
        val message: String
    ) : LoginResult()

    /**
     * Represents a login response with an error.
     */
    data class InvalidFields(
        val errors: List<ValidationFieldError>
    ) : LoginResult()

    /**
     * Login failed due to network or other technical issues
     */
    data class NetworkError(
        val message: String,
        val throwable: Throwable? = null
    ) : LoginResult()

    /**
     * Login failed due to server error
     */
    data class ServerError(
        val statusCode: Int,
        val message: String
    ) : LoginResult()
}

fun LoginResult.isSuccess(): Boolean {
    return this is LoginResult.Success
}

fun LoginResult.isError(): Boolean {
    return this is LoginResult.InvalidCredentials ||
            this is LoginResult.InvalidFields ||
            this is LoginResult.NetworkError ||
            this is LoginResult.ServerError
}

fun LoginResult.errorMessage(): String? {
    return when (this) {
        is LoginResult.InvalidCredentials -> message
        is LoginResult.InvalidFields -> errors.joinToString(", ") { it.message }
        is LoginResult.NetworkError -> message
        is LoginResult.ServerError -> message
        else -> null
    }
}