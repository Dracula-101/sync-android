package com.application.sync.core.network.interceptor

import android.os.Build
import com.application.sync.core.network.util.HEADER_DEVICE_ID
import com.application.sync.core.network.util.HEADER_DEVICE_MODEL
import com.application.sync.core.network.util.HEADER_DEVICE_NAME
import com.application.sync.core.network.util.HEADER_DEVICE_OS
import com.application.sync.core.network.util.HEADER_DEVICE_TYPE
import okhttp3.Interceptor
import okhttp3.Response

internal class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder()
            .addHeader(HEADER_DEVICE_ID, Build.ID)
            .addHeader(HEADER_DEVICE_NAME, Build.DEVICE)
            .addHeader(HEADER_DEVICE_MODEL, Build.MODEL)
            .addHeader(
                HEADER_DEVICE_OS,
                "Android ${Build.VERSION.RELEASE}: ${Build.VERSION.SDK_INT}"
            )
            .addHeader(
                HEADER_DEVICE_TYPE,
                "${Build.SUPPORTED_ABIS.firstOrNull() ?: "unknown"} (${Build.SUPPORTED_32_BIT_ABIS.firstOrNull() ?: "unknown"})"
            )
            .build()
    )

}
