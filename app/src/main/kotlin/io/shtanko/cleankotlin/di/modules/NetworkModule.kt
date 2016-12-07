package io.shtanko.cleankotlin.di.modules

import com.google.gson.Gson
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
  fun provideRetrofit(httpClient: OkHttpClient, baseUrl: String,
                      converter: Converter.Factory): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(converter)
        .client(httpClient).build()

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

  @Provides
  fun provideLogger(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> })
  }
}