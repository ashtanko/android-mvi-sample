package com.twere.android.clean.way.di.module

import android.content.Context
import android.content.res.Resources
import com.twere.android.clean.way.MainApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(): Context = MainApp.instance

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources = context.resources
}