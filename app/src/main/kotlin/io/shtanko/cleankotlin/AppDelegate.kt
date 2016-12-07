package io.shtanko.cleankotlin

import android.app.Application
import io.shtanko.cleankotlin.di.components.ApplicationComponent
import io.shtanko.cleankotlin.di.components.DaggerApplicationComponent

class AppDelegate : Application() {

  companion object {
    @JvmStatic lateinit var instance: AppDelegate
    @JvmStatic lateinit var appComponent: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    setupMainComponent()
  }

  private fun setupMainComponent() {
    appComponent = DaggerApplicationComponent.create()
  }

}