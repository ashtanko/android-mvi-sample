package com.twere.dribbblekotlin

import com.arellomobile.mvp.MvpApplication
import com.twere.dribbblekotlin.di.components.ApplicationComponent
import com.twere.dribbblekotlin.di.components.DaggerApplicationComponent

class DribbbleApplication : MvpApplication() {

  companion object {
    @JvmStatic lateinit var instance: DribbbleApplication
    @JvmStatic lateinit var appComponent: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }

  private fun setupMainComponent() {
    appComponent = DaggerApplicationComponent.create()
  }

}