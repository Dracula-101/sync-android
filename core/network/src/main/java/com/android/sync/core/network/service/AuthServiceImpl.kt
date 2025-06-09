package com.android.sync.core.network.service

import com.android.sync.core.network.api.AuthApi
import com.android.sync.core.network.model.LoginResponseJson
import com.android.sync.core.network.model.toSyncError
import com.android.sync.core.network.util.toResult
import timber.log.Timber

internal class AuthServiceImpl(
    private val authApi: AuthApi
) : AuthService {

    override suspend fun loginWithEmail(
        email: String,
        password: String
    ): Result<LoginResponseJson> =
        authApi.login(email, password)
            .toResult()
}