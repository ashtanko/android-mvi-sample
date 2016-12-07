package com.twere.dribbblekotlin.mvp.model.like

import com.twere.dribbblekotlin.mvp.model.shot.ShotRealm
import com.twere.dribbblekotlin.mvp.model.user.UserRealm
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class LikeRealm : RealmModel {

  @PrimaryKey
 open var id: Long = 0
 open var createdAt: Date? = null
 open var user: UserRealm? = null
 open var shot: ShotRealm? = null

}