package com.twere.android.clean.way

import android.app.Application
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.di.component.DaggerApplicationComponent

class MainApp : Application() {

    companion object {
        @JvmStatic lateinit var instance: MainApp
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