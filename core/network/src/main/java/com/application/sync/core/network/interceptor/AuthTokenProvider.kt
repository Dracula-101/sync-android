package com.application.sync.core.network.interceptor

interface AuthTokenProvider {

    fun getLatestAuthToken(): String?

}