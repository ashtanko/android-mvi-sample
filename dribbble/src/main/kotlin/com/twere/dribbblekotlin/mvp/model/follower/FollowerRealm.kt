package com.twere.dribbblekotlin.mvp.model.follower

import com.twere.dribbblekotlin.mvp.model.user.UserRealm
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class FollowerRealm : RealmModel {

  @PrimaryKey
 open var id: Long = 0
 open var createdAt: Date? = null
 open var follower: UserRealm? = null

}