package com.twere.dribbblekotlin.mvp.model.shot

import com.twere.dribbblekotlin.mvp.model.images.ImagesRealm
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date

@RealmClass
open class ShotRealm : RealmModel {

  @PrimaryKey
 open var id: Int = 0
 open var title: String = ""
 open var description: String = ""
 open var width: Int = 0
 open var height: Int = 0
 open var images: ImagesRealm? = null
 open var viewsCount: Long = 0
 open var likesCount: Long = 0
 open var commentsCount: Long = 0
 open var attachmentsCount: Long = 0
 open var reboundsCount: Long = 0
 open var bucketsCount: Long = 0
 open var createdAt: Date? = null
 open var updatedAt: Date? = null
 open var htmlUrl: String = ""
 open var attachmentsUrl: String = ""
 open var bucketsUrl: String = ""
 open var commentsUrl: String = ""
 open var likesUrl: String = ""
 open var projectsUrl: String = ""
 open var reboundsUrl: String = ""
  // var tags: Array<String>? = null

}