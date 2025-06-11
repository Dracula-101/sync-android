package com.application.sync.core.network.service

import com.application.sync.core.network.api.AuthApi
import com.application.sync.core.network.model.NetworkResponse
import com.application.sync.core.network.model.SyncError
import com.application.sync.core.network.model.ValidationFieldError
import com.application.sync.core.network.model.result.LoginResult
import timber.log.Timber

internal class AuthServiceImpl(
    private val authApi: AuthApi
) : AuthService {

    override suspend fun loginWithEmail(
        email: String,
        password: String
    ): LoginResult {
        return when (val response = authApi.login(email, password)) {
            is NetworkResponse.Success -> {
                Timber.d("Login successful: ${response.data.user}")
                LoginResult.Success(
                    user = response.data.user,
                    accessToken = response.data.accessToken,
                    refreshToken = response.data.refreshToken
                )
            }

            is NetworkResponse.Error -> {
                Timber.e("Login failed: ${response.error}")
                handleLoginError(response.error)
            }
        }
    }

    private fun handleLoginError(error: SyncError): LoginResult {
        return when (error) {
            is SyncError.Http -> {
                when {
                    error.isAuthenticationError -> {
                        // HTTP 401 - Invalid credentials
                        LoginResult.InvalidCredentials(
                            message = error.errorMessage
                        )
                    }

                    error.isValidationError -> {
                        // HTTP 422 - Validation errors
                        val validationErrors = error.errors?.mapNotNull { apiError ->
                            apiError.field?.let { field ->
                                ValidationFieldError(
                                    field = extractFieldName(field),
                                    message = apiError.message,
                                    code = apiError.code
                                )
                            }
                        } ?: emptyList()

                        LoginResult.InvalidFields(errors = validationErrors)
                    }

                    error.isServerError -> {
                        // HTTP 5xx - Server errors
                        LoginResult.ServerError(
                            statusCode = error.code,
                            message = error.errorMessage
                        )
                    }

                    else -> {
                        // Other HTTP errors
                        LoginResult.NetworkError(
                            message = "HTTP ${error.code}: ${error.errorMessage}",
                            throwable = error.throwable
                        )
                    }
                }
            }

            is SyncError.Network -> {
                LoginResult.NetworkError(
                    message = error.message,
                    throwable = error.throwable
                )
            }

            is SyncError.Other -> {
                LoginResult.NetworkError(
                    message = error.message,
                    throwable = error.throwable
                )
            }
        }
    }

    private fun extractFieldName(fieldPath: String): String {
        // Extract field name from paths like "form:password", "user.email", etc.
        return when {
            fieldPath.contains(":") -> fieldPath.substringAfter(":")
            fieldPath.contains(".") -> fieldPath.substringAfter(".")
            else -> fieldPath
        }
    }
}