package io.shtanko.cleankotlin.di.modules

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import io.shtanko.cleankotlin.AppDelegate
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule {

  @Provides
  @Singleton
  fun provideContext(): Context = AppDelegate.instance

  @Provides
  @Singleton
  fun provideResources(context: Context): Resources = context.resources

  @Provides
  @Singleton
  fun provideConnectivityManager(): ConnectivityManager {
    return AppDelegate.instance.getSystemService(
        Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  }
}