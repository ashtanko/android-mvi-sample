package com.twere.data.api.dribbble.service

import com.twere.data.api.dribbble.model.Project
import com.twere.data.api.dribbble.model.Shot
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface DribbbleProjectsService {

  @GET("projects/{id}")
  fun getProject(
      @Path("id") projectId: Long): Observable<Project>

  @GET("projects/{id}/shots")
  fun getShotsForProject(
      @Path("id") projectId: Long): Observable<List<Shot>>

}