package com.twere.dribbblekotlin.mvp.model.comment

import com.twere.dribbblekotlin.mvp.model.user.UserRealm
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class CommentRealm : RealmModel {

  @PrimaryKey
 open var id: Long = 0
 open var body: String = ""
 open var likesCount: Int = 0
 open var likesUrl: String = ""
 open var createdAt: Date? = null
 open var updatedAt: Date? = null
 open var user: UserRealm? = null
}