package com.twere.dribbblekotlin.mvp.model.attachment

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class AttachmentRealm() : RealmModel {

  @PrimaryKey
  open var id: Long = 0
  open var url: String = ""
  open var thumbnailUrl: String = ""
  open var size: Long = 0
  open var contentType: String = ""
  open var viewsCount: Int = 0
  open var createdAt: Date? = null

}