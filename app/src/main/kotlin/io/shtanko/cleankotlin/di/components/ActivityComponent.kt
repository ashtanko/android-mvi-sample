package io.shtanko.cleankotlin.di.components

import io.shtanko.cleankotlin.di.modules.ActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ActivityModule::class))
interface ActivityComponent {

}