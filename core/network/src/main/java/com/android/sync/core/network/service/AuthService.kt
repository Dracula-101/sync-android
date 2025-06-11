package com.android.sync.core.network.service

import com.android.sync.core.network.model.result.LoginResult

interface AuthService {

    suspend fun loginWithEmail(
        email: String,
        password: String
    ): LoginResult

}