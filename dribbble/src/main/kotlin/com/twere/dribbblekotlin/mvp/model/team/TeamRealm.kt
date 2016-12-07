package com.twere.dribbblekotlin.mvp.model.team

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class TeamRealm : RealmModel {

  @PrimaryKey
 open var id: Long = 0
 open var name: String = ""
 open var username: String = ""
 open var htmlUrl: String = ""
 open var avatarUrl: String = ""
 open var bio: String = ""
 open var location: String = ""
 open var bucketsCount: Long = 0
 open var commentsReceivedCount: Long = 0
 open var followersCount: Long = 0
 open var followingsCount: Long = 0
 open var likesCount: Long = 0
 open var likesReceivedCount: Long = 0

}