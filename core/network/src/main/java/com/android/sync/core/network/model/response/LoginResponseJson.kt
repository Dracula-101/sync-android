package com.android.sync.core.network.model.response

import com.google.gson.annotations.SerializedName

// Login specific data models
data class LoginResponse(
    @SerializedName("user")
    val user: User,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)

data class User(
    @SerializedName("id")
    val userId: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("verifiedEmail")
    val verifiedEmail: Boolean,
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("createdAt")
    val synergy: Synergy,
    @SerializedName("joinedWavelengths")
    val joinedWavelengths: List<String>,
    @SerializedName("moderatorOf")
    val moderatorOf: List<String>,
    @SerializedName("follows")
    val follows: Int,
    @SerializedName("followers")
    val followers: Int
)


data class Avatar(
    @SerializedName("profile")
    val profile: ImageInfo,
    @SerializedName("background")
    val background: ImageInfo
)

data class ImageInfo(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)

data class Synergy(
    @SerializedName("posts")
    val posts: Int,
    @SerializedName("comments")
    val comments: Int,
    @SerializedName("total")
    val total: Int
)