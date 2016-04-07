package com.twere.data

abstract class MainItem() {
  val id: Long = 0
  val title: String = ""
  var url: String = "" // can't be final as some APIs use different serialized names
  var dataSource: String = ""
  var page: Int = 0
  var weight: Float = 0.toFloat()
  var colspan: Int = 0
}