package io.shtanko.cleankotlin.di.components

import io.shtanko.cleankotlin.AppDelegate
import io.shtanko.cleankotlin.di.modules.ApplicationModule
import io.shtanko.cleankotlin.di.modules.HostModule
import io.shtanko.cleankotlin.di.modules.NetworkModule
import io.shtanko.cleankotlin.di.modules.RealmModule
import dagger.Component
import io.shtanko.cleankotlin.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        RealmModule::class,
        HostModule::class
))
interface ApplicationComponent {
    fun inject(app: AppDelegate)
    fun inject(activity: MainActivity)
    //fun inject(fragment: MainFragment)
}