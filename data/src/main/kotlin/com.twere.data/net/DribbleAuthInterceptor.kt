package com.twere.data.net

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class DribbleAuthInterceptor(var token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val request: Request = chain?.request()!!.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        return chain?.proceed(request)
    }
}