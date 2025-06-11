package com.application.sync.core.network.core

import com.application.sync.core.network.model.Meta
import com.application.sync.core.network.model.NetworkError
import com.application.sync.core.network.model.NetworkResponse
import com.application.sync.core.network.model.SyncError
import com.application.sync.core.network.util.toSyncError
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * A [Call] for wrapping a network request into a [NetworkResponse].
 */
internal class NetworkResponseCall<T>(
    private val backingCall: Call<ResponseBody>,
    private val gson: Gson,
    private val successType: Type,
) : Call<NetworkResponse<T>> {

    override fun cancel(): Unit = backingCall.cancel()

    override fun clone(): Call<NetworkResponse<T>> =
        NetworkResponseCall(backingCall.clone(), gson, successType)

    override fun enqueue(callback: Callback<NetworkResponse<T>>): Unit = backingCall.enqueue(
        object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                callback.onResponse(
                    this@NetworkResponseCall,
                    Response.success(response.toNetworkResponse()),
                )
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                val networkResponse = NetworkResponse.Error(
                    meta = Meta(
                        success = false,
                        statusCode = -1,
                        timestamp = System.currentTimeMillis().toString()
                    ),
                    error = t.toSyncError()
                )
                callback.onResponse(
                    this@NetworkResponseCall,
                    Response.success(networkResponse)
                )
            }
        },
    )

    override fun execute(): Response<NetworkResponse<T>> =
        try {
            Response.success(backingCall.execute().toNetworkResponse())
        } catch (exception: Exception) {
            val networkResponse = NetworkResponse.Error(
                meta = Meta(
                    success = false,
                    statusCode = -1,
                    timestamp = System.currentTimeMillis().toString()
                ),
                error = exception.toSyncError()
            )
            Response.success(networkResponse)
        }

    override fun isCanceled(): Boolean = backingCall.isCanceled

    override fun isExecuted(): Boolean = backingCall.isExecuted

    override fun request(): Request = backingCall.request()

    override fun timeout(): Timeout = backingCall.timeout()

    /**
     * Synchronously send the request and return its response as a [NetworkResponse].
     */
    fun executeForResult(): NetworkResponse<T> = requireNotNull(execute().body())

    private fun Response<ResponseBody>.toNetworkResponse(): NetworkResponse<T> {
        return try {
            val responseBody = body()?.string() ?: errorBody()?.string() ?: ""
            if (responseBody.isEmpty()) {
                return NetworkResponse.Error(
                    meta = Meta(
                        success = false,
                        statusCode = code(),
                        timestamp = System.currentTimeMillis().toString()
                    ),
                    error = SyncError.Http(
                        throwable = HttpException(this),
                        message = "Empty response body",
                        errors = listOf(
                            NetworkError(
                                code = "EMPTY_RESPONSE",
                                message = "Server returned empty response",
                                detail = "HTTP ${code()}"
                            )
                        )
                    )
                )
            }

            // Parse the JSON to determine if it's success or error
            val jsonObject = gson.fromJson(responseBody, com.google.gson.JsonObject::class.java)
            val meta = jsonObject.getAsJsonObject("meta")
            val isSuccess = meta?.get("success")?.asBoolean ?: false

            if (isSuccess) {
                // Parse as success response
                val successResponse =
                    gson.fromJson(responseBody, createSuccessType()) as NetworkSuccessResponse<T>
                NetworkResponse.Success(
                    meta = successResponse.meta,
                    message = successResponse.message,
                    data = successResponse.data
                )
            } else {
                // Parse as error response
                val errorResponse = gson.fromJson(responseBody, NetworkErrorResponse::class.java)
                NetworkResponse.Error(
                    meta = errorResponse.meta,
                    error = SyncError.Http(
                        throwable = HttpException(this),
                        message = errorResponse.message,
                        errors = errorResponse.errors
                    )
                )
            }
        } catch (e: JsonSyntaxException) {
            Timber.e(e, "Failed to parse response JSON")
            NetworkResponse.Error(
                meta = Meta(
                    success = false,
                    statusCode = code(),
                    timestamp = System.currentTimeMillis().toString()
                ),
                error = SyncError.Http(
                    throwable = HttpException(this),
                    message = "Failed to parse response",
                    errors = listOf(
                        NetworkError(
                            code = "JSON_PARSE_ERROR",
                            message = "Failed to parse server response",
                            detail = e.message
                        )
                    )
                )
            )
        } catch (e: Exception) {
            Timber.e(e, "Unexpected error parsing response")
            NetworkResponse.Error(
                meta = Meta(
                    success = false,
                    statusCode = code(),
                    timestamp = System.currentTimeMillis().toString()
                ),
                error = e.toSyncError()
            )
        }
    }

    private fun createSuccessType(): Type {
        return object : ParameterizedType {
            override fun getActualTypeArguments(): Array<Type> = arrayOf(successType)
            override fun getRawType(): Type = NetworkSuccessResponse::class.java
            override fun getOwnerType(): Type? = null
        }
    }
}

// Helper classes for parsing
internal data class NetworkSuccessResponse<T>(
    val meta: Meta,
    val message: String,
    val data: T
)

internal data class NetworkErrorResponse(
    val meta: Meta,
    val message: String,
    val errors: List<NetworkError>? = null
)