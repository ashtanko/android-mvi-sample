package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Like(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("created_at") @Expose var createdAt: Date,
    @SerializedName("user") @Expose var user: User,
    @SerializedName("shot") @Expose var shot: Shot) {

}