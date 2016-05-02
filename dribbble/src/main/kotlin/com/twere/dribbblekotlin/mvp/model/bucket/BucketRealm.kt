package com.twere.dribbblekotlin.mvp.model.bucket

import com.twere.dribbblekotlin.mvp.model.user.UserRealm
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class BucketRealm : RealmModel {

  @PrimaryKey
open var id: Int = 0
open var name: String = ""
open var description: String = ""
open var shotsCount: Int = 0
open var createdAt: Date? = null
open var updatedAt: Date? = null
open var user: UserRealm? = null

}