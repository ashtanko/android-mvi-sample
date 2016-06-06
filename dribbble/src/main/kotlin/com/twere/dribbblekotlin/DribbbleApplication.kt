package com.twere.dribbblekotlin

import android.app.Application
import com.twere.dribbblekotlin.di.components.ApplicationComponent
import com.twere.dribbblekotlin.di.components.DaggerApplicationComponent

class DribbbleApplication : Application() {

  companion object {
    @JvmStatic lateinit var instance: DribbbleApplication
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