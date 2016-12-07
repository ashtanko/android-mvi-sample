package com.twere.dribbblekotlin.mvp.model.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.twere.dribbblekotlin.mvp.model.shot.Shot
import com.twere.dribbblekotlin.mvp.model.user.User
import java.util.Date

data class Like(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("created_at") @Expose var createdAt: Date,
    @SerializedName("user") @Expose var user: User,
    @SerializedName("shot") @Expose var shot: Shot) {

}