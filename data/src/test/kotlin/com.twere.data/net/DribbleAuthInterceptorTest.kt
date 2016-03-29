package com.twere.data.net

import com.twere.data.BuildConfig
import okhttp3.OkHttpClient
import org.junit.Test

class DribbleAuthInterceptorTest {

    @Test
    fun authTest() {
        var client: OkHttpClient = OkHttpClient.Builder().addInterceptor(DribbleAuthInterceptor(BuildConfig.DRIBBBLE_CLIENT_ACCESS_TOKEN)).build()
        client.authenticator().apply {  }
    }
}