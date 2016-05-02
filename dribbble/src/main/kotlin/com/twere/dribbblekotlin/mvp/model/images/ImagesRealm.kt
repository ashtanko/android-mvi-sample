package com.twere.dribbblekotlin.mvp.model.images

import io.realm.RealmModel
import io.realm.annotations.RealmClass

@RealmClass
open class ImagesRealm : RealmModel {

 open var normal: String = ""
 open var teaser: String = ""

}