package com.android.sync.core.network.core

import com.android.sync.core.network.model.NetworkResponse
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type


/**
 * A [CallAdapter] for wrapping network requests into [NetworkResponse].
 */
internal class NetworkResponseCallAdapter<T>(
    private val successType: Type,
    private val gson: Gson,
) : CallAdapter<T, Call<NetworkResponse<T>>> {

    override fun responseType(): Type = ResponseBody::class.java

    override fun adapt(call: Call<T>): Call<NetworkResponse<T>> {
        @Suppress("UNCHECKED_CAST")
        return NetworkResponseCall(call as Call<ResponseBody>, gson, successType)
    }
}