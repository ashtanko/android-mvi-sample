package com.twere.android.clean.way.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.twere.data.api.dribbble.DribbleService
import com.twere.data.prefs.DRIBBBLE_DATE_FORMAT
import com.twere.data.util.log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

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
    fun provideClient(networkTimeoutSecond: Long): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder =
                OkHttpClient.Builder()
                        .readTimeout(networkTimeoutSecond, TimeUnit.SECONDS)
                        .connectTimeout(networkTimeoutSecond, TimeUnit.SECONDS)
        return okHttpClientBuilder.build()
    }

/*    @Provides
    @Singleton
    fun provideDribbleClient(): OkHttpClient {
        val okHttpDribbleClientBuilder: OkHttpClient.Builder =
                OkHttpClient.Builder()
                        .addInterceptor(DribbleAuthInterceptor(BuildConfig.DRIBBBLE_CLIENT_ACCESS_TOKEN))
        return okHttpDribbleClientBuilder.build()
    }*/

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setDateFormat(DRIBBBLE_DATE_FORMAT).create()

    @Provides
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> log(message) })
    }

}