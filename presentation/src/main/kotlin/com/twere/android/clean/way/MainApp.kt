package com.twere.android.clean.way

import android.app.Application
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.di.component.DaggerApplicationComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class MainApp : Application() {

  companion object {
    @JvmStatic lateinit var instance: MainApp
    @JvmStatic lateinit var appComponent: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    setupMainComponent()
    realmConfig()
  }

  private fun setupMainComponent() {
    appComponent = DaggerApplicationComponent.create()
  }

  private fun realmConfig() {
    val config = RealmConfiguration.Builder(this).build()
    Realm.deleteRealm(config);
    Realm.setDefaultConfiguration(config);
  }
}