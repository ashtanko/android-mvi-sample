package com.twere.data.api.dribbble.service

import com.twere.data.api.dribbble.model.Attachment
import com.twere.data.api.dribbble.model.Bucket
import com.twere.data.api.dribbble.model.Comment
import com.twere.data.api.dribbble.model.Like
import com.twere.data.api.dribbble.model.Project
import com.twere.data.api.dribbble.model.Rebound
import com.twere.data.api.dribbble.model.Shot
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import rx.Observable

interface DribbbleShotsService {

  @GET("shots")
  fun fetchShots(
      @Query("page") page: Int): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @Query("page") page: Int,
      @Query("per_page") perPage: Int): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @Query("page") page: Int,
      @Query("per_page") perPage: Int,
      @Query("list") list: String,
      @Query("sort") sort: String): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @Query("page") page: Int,
      @Query("per_page") perPage: Int,
      @Query("list") list: String,
      @Query("sort") sort: String,
      @Query("date") date: String,
      @Query("timeframe") timeframe: String): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @Query("page") page: Int,
      @Query("list") list: String,
      @Query("sort") sort: String,
      @Query("date") date: String,
      @Query("timeframe") timeframe: String): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @Query("list") list: String): Observable<List<Shot>>

  @GET("shots")
  fun fetchShots(
      @QueryMap parameters: Map<String, Any>): Observable<List<Shot>>

  @GET("shots")
  fun fetchSortedShots(
      @Query("sort") sort: String): Observable<List<Shot>>

  @GET("shots/{id}")
  fun getShot(
      @Path("id") shotId: Long): Observable<Shot>

  @Multipart
  @POST("shots")
  fun createShot(
      @Part("title") title: String,
      @Part("image") image: RequestBody,
      @Part("description") description: String,
      @Part("tags") tags: Array<String>,
      @Part("team_id") team_id: Int,
      @Part("rebound_source_id") reboundSourceId: Int
  ): Observable<Void>

  @Multipart
  @POST("shots")
  fun createShot(
      @Part("title") title: String,
      @Part("image") image: RequestBody,
      @Part("description") description: String,
      @Part("tags") tags: Array<String>
  ): Observable<Void>

  @Multipart
  @POST("shots")
  fun createShot(
      @PartMap partMap: Map<String, Any>
  ): Observable<Void>

  @Multipart
  @PUT("shots/{id}")
  fun updateShot(
      @Part("id") shotId: Long,
      @Part("title") title: String,
      @Part("description") description: String,
      @Part("tags") tags: Array<String>
  ): Observable<Shot>

  @DELETE("shots/{id}")
  fun deleteShot(
      @Path("id") shotId: Long
  ): Observable<Void>

  @GET("shots/{id}/attachments")
  fun getShotAttachments(
      @Path("id") shotId: Long): Observable<List<Attachment>>

  @POST("shots/{shot}/attachments")
  fun createShotAttachment(
      @Path("shot") shotId: Long,
      @Part("file") file: RequestBody): Observable<Void>

  @GET("shots/{shot}/attachments/{id}")
  fun getShotAttachment(
      @Path("shot") shotId: Long,
      @Path("id") attachmentId: Long): Observable<Attachment>

  @DELETE("shots/{shot}/attachments/{id}")
  fun deleteShotAttachment(
      @Path("shot") shotId: Long,
      @Path("id") attachmentId: Long): Observable<Void>

  @GET("shots/{id}/buckets")
  fun getShotBuckets(
      @Path("id") shotId: Long): Observable<List<Bucket>>

  @GET("shots/{shot}/comments")
  fun getShotComments(
      @Path("shot") shotId: Long): Observable<List<Comment>>

  @GET("shots/{shot}/comments/{id}/likes")
  fun getCommentLikes(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<List<Like>>

  @POST("shots/{shot}/comments")
  fun createComment(
      @Path("shot") shotId: Long,
      @Body body: Comment): Observable<Comment>

  @GET("shots/{shot}/comments/{id}")
  fun getShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<Comment>

  @PUT("shots/{shot}/comments/{id}")
  fun updateShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long,
      @Body body: Comment): Observable<Comment>

  @DELETE("shots/{shot}/comments/{id}")
  fun deleteShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<Void>

  @GET("shots/{shot}/comments/{id}/like")
  fun checkIsLikedShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<Like>

  @POST("shots/{shot}/comments/{id}/like")
  fun likeShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<Like>

  @DELETE("shots/{shot}/comments/{id}/like")
  fun unlikeShotComment(
      @Path("shot") shotId: Long,
      @Path("id") commentId: Long): Observable<Void>

  @GET("shots/{id}/likes")
  fun getShotLikes(
      @Path("id") shotId: Long): Observable<List<Like>>

  @GET("shots/{id}/likes")
  fun checkShotIsLiked(
      @Path("id") shotId: Long): Observable<Like>

  @POST("shots/{id}/likes")
  fun likeShot(
      @Path("id") shotId: Long): Observable<Like>

  @DELETE("shots/{id}/likes")
  fun unlikeShot(
      @Path("id") shotId: Long): Observable<Like>

  @GET("shots/{id}/projects")
  fun getShotProjectsList(
      @Path("id") shotId: Long): Observable<List<Project>>

  @GET("shots/{id}/rebounds")
  fun getShotReboundsList(
      @Path("id") shotId: Long): Observable<List<Rebound>>

}