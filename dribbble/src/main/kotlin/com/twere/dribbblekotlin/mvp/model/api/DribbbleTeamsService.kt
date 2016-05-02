package com.twere.dribbblekotlin.mvp.model.api

import com.twere.dribbblekotlin.mvp.model.shot.Shot
import com.twere.dribbblekotlin.mvp.model.user.User
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface DribbbleTeamsService {

  @GET("teams/{team}/members")
  fun getTeamMembersList(
      @Path("team") teamId: Long): Observable<List<User>>

  @GET("teams/{team}/shots")
  fun getTeamShotsList(
      @Path("team") teamId: Long): Observable<List<Shot>>

}