package com.twere.dribbblekotlin.mvp.model.user

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class UserRealm : RealmModel {

  @PrimaryKey
  open var id: Long = 0
  open var name: String = ""
  open var username: String = ""
  open var html_url: String = ""
  open var avatarUrl: String = ""
  open var bio: String = ""
  open var location: String = ""
  //var links: Map<String, String>? = null
  open var bucketsCount: Long = 0
  open var commentsReceivedCount: Long = 0
  open var followersCount: Long = 0
  open var followingsCount: Long = 0
  open var likes_count: Long = 0
  open var likesReceivedCount: Long = 0
  open var projectsCount: Long = 0
  open var reboundsReceivedCount: Long = 0
  open var shotsCount: Long = 0
  open var teamsCount: Long = 0
  open var canUploadShot: Boolean = false
  open var type: String = ""
  open var pro: Boolean = false
  open var bucketsUrl: String = ""
  open var followersUrl: String = ""
  open var followingUrl: String = ""
  open var likesUrl: String = ""
  open var shotsUrl: String = ""
  open var teamsUrl: String = ""
  open var createdAt: Date? = null
  open var updatedAt: Date? = null

}