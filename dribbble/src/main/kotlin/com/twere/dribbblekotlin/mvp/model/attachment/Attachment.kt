package com.twere.dribbblekotlin.mvp.model.attachment

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Attachment(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("url") @Expose var url: String,
    @SerializedName("thumbnail_url") @Expose var thumbnailUrl: String,
    @SerializedName("size") @Expose var size: Long,
    @SerializedName("content_type") @Expose var contentType: String,
    @SerializedName("views_count") @Expose var viewsCount: Int,
    @SerializedName("created_at") @Expose var createdAt: Date) {

}