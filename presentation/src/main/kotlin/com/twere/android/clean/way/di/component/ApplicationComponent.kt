package com.twere.android.clean.way.di.component

import com.twere.android.clean.way.MainApp
import com.twere.android.clean.way.di.module.ApplicationModule
import com.twere.android.clean.way.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(app: MainApp)
    fun inject(activity: MainActivity)
}