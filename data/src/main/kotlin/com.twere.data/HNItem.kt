package com.twere.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HNItem(

    @SerializedName("items")
    @Expose val items: List<Int>,

    @SerializedName("profiles")
    @Expose
    val profiles: List<String>) {

}
