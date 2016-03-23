package com.twere.android.clean.way.util

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtil {

    var TYPE_WIFI = 1
    var TYPE_MOBILE = 2
    var TYPE_NOT_CONNECTED = 0

    private val connectivityManager: ConnectivityManager? = null
    private val context: Context? = null

    fun getConnectivityStatus(): Int {
        val activeNetwork = connectivityManager!!.activeNetworkInfo
        if (null != activeNetwork) {
            when (activeNetwork.type) {
                ConnectivityManager.TYPE_WIFI -> TYPE_WIFI
                ConnectivityManager.TYPE_MOBILE -> TYPE_MOBILE
            }
        }
        return TYPE_NOT_CONNECTED
    }
}