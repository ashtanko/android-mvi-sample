package com.twere.dribbblekotlin.di.components

import com.twere.dribbblekotlin.di.modules.FragmentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    FragmentModule::class))
interface FragmentComponent {
}