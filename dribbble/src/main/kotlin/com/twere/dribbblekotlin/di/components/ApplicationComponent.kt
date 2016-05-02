package com.twere.dribbblekotlin.di.components

import com.twere.dribbblekotlin.DribbbleApplication
import com.twere.dribbblekotlin.di.modules.ApplicationModule
import com.twere.dribbblekotlin.di.modules.DribbbleNetworkModule
import com.twere.dribbblekotlin.di.modules.HostModule
import com.twere.dribbblekotlin.di.modules.NetworkModule
import com.twere.dribbblekotlin.di.modules.RealmModule
import com.twere.dribbblekotlin.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class,
    NetworkModule::class,
    RealmModule::class,
    HostModule::class,
    DribbbleNetworkModule::class
))
interface ApplicationComponent {
  fun inject(app: DribbbleApplication)
  fun inject(activity: MainActivity)
  //fun inject(fragment: MainFragment)
}