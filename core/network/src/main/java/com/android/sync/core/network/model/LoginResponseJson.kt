package com.android.sync.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
sealed class LoginResponseJson {

    @Serializable
    data class Success(
        @SerialName("data")
        val data: LoginDataJson,
    ) : LoginResponseJson()

    @Serializable
    data class Error(
        @SerialName("message")
        val message: String,
        @SerialName("errors")
        val errors: List<ErrorJson>,
    ) : LoginResponseJson() {
        @Serializable
        data class ErrorJson(
            @SerialName("code")
            val code: String,
            @SerialName("message")
            val message: String,
            @SerialName("detail")
            val detail: String,
        )
    }
}


@Serializable
data class LoginDataJson(
    @SerialName("user")
    val user: UserJson,
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String,
)

@Serializable
data class UserJson(
    @SerialName("userId")
    val userId: String,
    @SerialName("username")
    val username: String,
    @SerialName("email")
    val email: String,
    @SerialName("bio")
    val bio: String,
    @SerialName("verifiedEmail")
    val verifiedEmail: Boolean,
    @SerialName("avatar")
    val avatar: AvatarJson,
    @SerialName("synergy")
    val synergy: SynergyJson,
    @SerialName("joinedWavelengths")
    val joinedWavelengths: List<String>,
    @SerialName("moderatorOf")
    val moderatorOf: List<String>,
    @SerialName("follows")
    val follows: Int,
    @SerialName("followers")
    val followers: Int,
)

@Serializable
data class AvatarJson(
    @SerialName("profile")
    val profile: ImageJson,
    @SerialName("background")
    val background: ImageJson,
)

@Serializable
data class ImageJson(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
)

@Serializable
data class SynergyJson(
    @SerialName("posts")
    val posts: Int,
    @SerialName("comments")
    val comments: Int,
    @SerialName("total")
    val total: Int,
)