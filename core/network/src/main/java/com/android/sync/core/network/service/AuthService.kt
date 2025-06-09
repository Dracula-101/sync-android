package com.android.sync.core.network.service

import com.android.sync.core.network.model.LoginResponseJson

interface AuthService {

    suspend fun loginWithEmail(
        email: String,
        password: String
    ): Result<LoginResponseJson>

}