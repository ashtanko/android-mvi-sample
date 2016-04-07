package com.twere.data.prefs

import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.twere.data.BuildConfig
import com.twere.data.api.dribbble.DribbleService
import com.twere.data.net.DribbleAuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Arrays

class DribbblePrefs {

  val LOGIN_CALLBACK = "dribbble-auth-callback"
  val LOGIN_URL = "https://dribbble.com/oauth/authorize?client_id=" + BuildConfig.DRIBBBLE_CLIENT_ID + "&redirect_uri=plaid%3A%2F%2F" + LOGIN_CALLBACK + "&scope=public+write+comment+upload"
  private val DRIBBBLE_PREF = "DRIBBBLE_PREF"
  private val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
  private val KEY_USER_ID = "KEY_USER_ID"
  private val KEY_USER_NAME = "KEY_USER_NAME"
  private val KEY_USER_USERNAME = "KEY_USER_USERNAME"
  private val KEY_USER_AVATAR = "KEY_USER_AVATAR"
  private val KEY_USER_TYPE = "KEY_USER_TYPE"
  private val CREATIVE_TYPES = Arrays.asList(*arrayOf("Player", "Team"))
  @Volatile private var singleton: DribbblePrefs? = null
  private val prefs: SharedPreferences? = null
  private var accessToken: String? = null
  private var isLoggedIn = false
  private var userId: Long = 0
  private var userName: String? = null
  private var userUsername: String? = null
  private var userAvatar: String? = null
  private var userType: String? = null
  private var loginStatusListeners: MutableList<DribbbleLoginStatusListener>? = null
  private var api: DribbleService? = null

  private fun createApi() {
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(DribbleAuthInterceptor(getAccessToken()))
        .build()

    api = Retrofit.Builder()
        .baseUrl(DRIBBBLE_ENDPOINT)
        .client(client)
        .addConverterFactory(GsonConverterFactory
            .create(GsonBuilder().
                setDateFormat(DRIBBBLE_DATE_FORMAT)
                .create()))
        .build()
        .create(DribbleService::class.java)
  }

  private fun getAccessToken(): String {
    return BuildConfig.DRIBBBLE_CLIENT_ACCESS_TOKEN
  }

}

