package com.twere.dribbblekotlin.di.modules

import com.twere.dribbblekotlin.mvp.model.api.DribbbleBucketsService
import com.twere.dribbblekotlin.mvp.model.api.DribbbleProjectsService
import com.twere.dribbblekotlin.mvp.model.api.DribbbleShotsService
import com.twere.dribbblekotlin.mvp.model.api.DribbbleTeamsService
import com.twere.dribbblekotlin.mvp.model.api.DribbbleUserService
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