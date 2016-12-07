package io.shtanko.cleankotlin.di.components

import io.shtanko.cleankotlin.di.modules.FragmentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    FragmentModule::class))
interface FragmentComponent {
}