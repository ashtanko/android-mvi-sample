package com.twere.android.clean.way.di.module

import com.twere.data.api.dribbble.service.DribbbleBucketsService
import com.twere.data.api.dribbble.service.DribbbleProjectsService
import com.twere.data.api.dribbble.service.DribbbleShotsService
import com.twere.data.api.dribbble.service.DribbbleTeamsService
import com.twere.data.api.dribbble.service.DribbbleUserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DribbbleNetworkModule{

  @Provides
  @Singleton
  fun provideDribbbleBucketService(retrofit: Retrofit): DribbbleBucketsService {
    return retrofit.create(DribbbleBucketsService::class.java)
  }

  @Provides
  @Singleton
  fun provideDribbbleProjectsService(retrofit: Retrofit): DribbbleProjectsService {
    return retrofit.create(DribbbleProjectsService::class.java)
  }

  @Provides
  @Singleton
  fun provideDribbbleShotsService(retrofit: Retrofit): DribbbleShotsService {
    return retrofit.create(DribbbleShotsService::class.java)
  }

  @Provides
  @Singleton
  fun provideDribbbleTeamsService(retrofit: Retrofit): DribbbleTeamsService {
    return retrofit.create(DribbbleTeamsService::class.java)
  }

  @Provides
  @Singleton
  fun provideDribbbleUserService(retrofit: Retrofit): DribbbleUserService {
    return retrofit.create(DribbbleUserService::class.java)
  }
}