package com.twere.data.net

import com.twere.data.util.log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

open class LoggingInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain?): Response? {
    val request: Request = chain!!.request()
    val t1 = System.nanoTime()
    log("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers())
    val response = chain.proceed(request)
    //request.header("")
    return response
  }
}