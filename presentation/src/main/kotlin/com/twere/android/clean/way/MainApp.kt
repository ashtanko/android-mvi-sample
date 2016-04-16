package com.twere.android.clean.way

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.di.component.DaggerApplicationComponent
import com.twere.presentation.BuildConfig
import io.fabric.sdk.android.Fabric
import io.realm.Realm
import io.realm.RealmConfiguration

final class MainApp : Application() {

  companion object {
    @JvmStatic lateinit var instance: MainApp
    @JvmStatic lateinit var appComponent: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()
    initCrashlytics()
    instance = this
    setupMainComponent()
    realmConfig()
  }

  fun initCrashlytics() {
    var crashlyticsKit: Crashlytics = Crashlytics.Builder()
        .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()).build()
    Fabric.with(this, crashlyticsKit)
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