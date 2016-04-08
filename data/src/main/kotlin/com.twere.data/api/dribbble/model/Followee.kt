package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Followee(
    @SerializedName("id") @Expose var id:Long,
    @SerializedName("created_at") @Expose var createdAt:Date,
    @SerializedName("followee") @Expose var followee:User) {

}