package com.android.sync.core.network.api

import com.android.sync.core.network.model.NetworkResponse
import com.android.sync.core.network.model.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface AuthApi {

    @FormUrlEncoded
    @POST("/api/v1/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<LoginResponse>

}