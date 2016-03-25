package com.twere.android.clean.way.di.module

import com.twere.presentation.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HostModule {

    val NETWORK_TIMEOUT_SECONDS = 60L

    @Provides
    @Singleton
    fun provideNetworkTimeout(): Long = NETWORK_TIMEOUT_SECONDS

    @Provides
    @Singleton
    fun provideBaseUrl(): String = BuildConfig.ENDPOINT
}