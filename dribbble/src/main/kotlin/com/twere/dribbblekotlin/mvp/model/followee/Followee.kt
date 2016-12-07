package com.twere.dribbblekotlin.mvp.model.followee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.twere.dribbblekotlin.mvp.model.user.User
import java.util.Date

data class Followee(
    @SerializedName("id") @Expose var id:Long,
    @SerializedName("created_at") @Expose var createdAt:Date,
    @SerializedName("followee") @Expose var followee: User) {

}