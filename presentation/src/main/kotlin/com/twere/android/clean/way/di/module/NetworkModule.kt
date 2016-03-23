package com.twere.android.clean.way.di.module

import com.google.gson.Gson
import com.twere.data.api.dribbble.DribbleService
import com.twere.presentation.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    val NETWORK_TIMEOUT_SECONDS = 60L

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, baseUrl: String, converter: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .client(httpClient).build()

    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): DribbleService {
        return retrofit.create(DribbleService::class.java)
    }

    @Provides
    @Singleton
    fun provideConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideNetworkTimeout(): Long = NETWORK_TIMEOUT_SECONDS

    @Provides
    @Singleton
    fun provideBaseUrl(): String = BuildConfig.API_URL

    @Provides
    @Singleton
    fun provideEndpoint(): String = BuildConfig.ENDPOINT
}