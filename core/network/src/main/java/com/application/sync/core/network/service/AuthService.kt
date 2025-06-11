package com.application.sync.core.network.service

import com.application.sync.core.network.model.result.LoginResult

interface AuthService {

    suspend fun loginWithEmail(
        email: String,
        password: String
    ): LoginResult

}