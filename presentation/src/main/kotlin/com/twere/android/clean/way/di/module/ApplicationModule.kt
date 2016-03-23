package com.twere.android.clean.way.di.module

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import com.twere.android.clean.way.MainApp
import com.twere.android.clean.way.util.NetworkUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(): Context = MainApp.instance

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
        return MainApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}