package com.application.sync.core.network.model

/**
 * Represents a validation error for a specific field
 */
data class ValidationFieldError(
    val field: String,
    val message: String,
    val code: String? = null
)