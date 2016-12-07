package com.twere.dribbblekotlin.mvp.model.api

import com.twere.dribbblekotlin.mvp.model.bucket.Bucket
import com.twere.dribbblekotlin.mvp.model.shot.Shot
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface DribbbleBucketsService {

  @GET("buckets/{id}")
  fun getBucket(
      @Path("id") bucketId: Long): Observable<Bucket>

  @POST("buckets")
  fun createBucket(
      @Body bucket: Bucket): Observable<Bucket>

  @PUT("buckets/{id}")
  fun updateBucket(
      @Path("id") bucketId: Long, @Body bucket: Bucket): Observable<Bucket>

  @DELETE("buckets/{id}")
  fun deleteBucket(
      @Path("id") bucketId: Long): Observable<Bucket>

  @GET("buckets/{id}/shots")
  fun getShotsForBucket(
      @Path("id") bucketId: Long): Observable<List<Shot>>

  @PUT("buckets/{id}/shots")
  fun addShotToBucket(
      @Path("id") bucketId: Long, @Query("shot_id") shotId: Long): Observable<Void>

  @DELETE("buckets/{id}/shots")
  fun removeShotFromBucket(
      @Path("id") bucketId: Long, @Query("shot_id") shotId: Long): Observable<Void>

}