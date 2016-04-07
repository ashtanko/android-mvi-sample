package com.twere.data.api.dribbble

import com.twere.data.DribbleItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface DribbleService {

  @GET("/shots")
  fun getPopular(
      @Query("page") page: Int,
      @Query("per_page") pageSize: Int): Observable<List<DribbleItem>>

  @GET("/shots?sort=recent")
  fun getRecent(
      @Query("page") page: Int,
      @Query("per_page") pageSize: Int): Observable<List<DribbleItem>>

  @GET("/shots?list=debuts")
  fun getDebuts(
      @Query("page") page: Int,
      @Query("per_page") pageSize: Int): Observable<List<DribbleItem>>

  @GET("/shots?list=animated")
  fun getAnimated(
      @Query("page") page: Int,
      @Query("per_page") pageSize: Int): Observable<List<DribbleItem>>

  @GET("/shots")
  fun getShots(
      @Query("page") page: Int,
      @Query("per_page") pageSize: Int): Observable<List<DribbleItem>>

  @GET("/shots/{id}")
  fun getShot(@Path("id") shotId: Long): DribbleItem
}