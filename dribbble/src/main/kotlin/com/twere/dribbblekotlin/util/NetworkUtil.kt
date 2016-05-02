package com.twere.dribbblekotlin.util

import android.net.ConnectivityManager

class NetworkUtil(connectivityManager: ConnectivityManager) {

  var TYPE_WIFI = 1
  var TYPE_MOBILE = 2
  var TYPE_NOT_CONNECTED = 0

  private val connectivityManager: ConnectivityManager = connectivityManager

  fun getConnectivityStatus(): Int {
    val activeNetwork = connectivityManager.activeNetworkInfo
    if (null != activeNetwork) {
      when (activeNetwork.type) {
        ConnectivityManager.TYPE_WIFI -> TYPE_WIFI
        ConnectivityManager.TYPE_MOBILE -> TYPE_MOBILE
      }
    }
    return TYPE_NOT_CONNECTED
  }
}