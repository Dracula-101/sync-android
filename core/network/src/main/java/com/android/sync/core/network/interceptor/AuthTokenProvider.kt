package com.android.sync.core.network.interceptor

interface AuthTokenProvider {

    fun getLatestAuthToken(): String?

}