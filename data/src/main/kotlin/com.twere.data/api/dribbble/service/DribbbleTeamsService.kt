package com.twere.data.api.dribbble.service

import com.twere.data.api.dribbble.model.Shot
import com.twere.data.api.dribbble.model.User
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