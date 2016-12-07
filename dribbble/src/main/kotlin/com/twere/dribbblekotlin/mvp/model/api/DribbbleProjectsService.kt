package com.twere.dribbblekotlin.mvp.model.api

import com.twere.dribbblekotlin.mvp.model.project.Project
import com.twere.dribbblekotlin.mvp.model.shot.Shot
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