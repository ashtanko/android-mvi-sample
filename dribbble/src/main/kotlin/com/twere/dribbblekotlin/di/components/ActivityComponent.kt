package com.twere.dribbblekotlin.di.components

import com.twere.dribbblekotlin.di.modules.ActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ActivityModule::class))
interface ActivityComponent {

}