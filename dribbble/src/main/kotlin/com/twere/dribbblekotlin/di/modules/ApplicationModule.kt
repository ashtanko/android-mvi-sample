package com.twere.dribbblekotlin.di.modules

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import com.twere.dribbblekotlin.DribbbleApplication
import com.twere.dribbblekotlin.util.NetworkUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule {

  @Provides
  @Singleton
  fun provideContext(): Context = DribbbleApplication.instance

  @Provides
  @Singleton
  fun provideResources(context: Context): Resources = context.resources

  @Provides
  @Singleton
  fun provideNetworkUtil(connectivityManager: ConnectivityManager): NetworkUtil {
    return NetworkUtil(connectivityManager)
  }

  @Provides
  @Singleton
  fun provideConnectivityManager(): ConnectivityManager {
    return DribbbleApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  }
}