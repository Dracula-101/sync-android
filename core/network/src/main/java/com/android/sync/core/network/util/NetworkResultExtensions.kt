package com.android.sync.core.network.util

import com.android.sync.core.network.model.NetworkResult

/**
 * Converts the [NetworkResult] to a [Result].
 */
internal fun <T> NetworkResult<T>.toResult(): Result<T> =
    when (this) {
        is NetworkResult.Failure -> this.throwable.asFailure()
        is NetworkResult.Success -> this.value.asSuccess()
    }
