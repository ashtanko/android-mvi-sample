package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Shot(
    @SerializedName("id") @Expose var id: Int,
    @SerializedName("title") @Expose var title: String,
    @SerializedName("description") @Expose var description: String,
    @SerializedName("width") @Expose var width: Int,
    @SerializedName("height") @Expose var height: Int,
    @SerializedName("images") @Expose var images: Images,
    @SerializedName("views_count") @Expose var viewsCount: Long,
    @SerializedName("likes_count") @Expose var likesCount: Long,
    @SerializedName("comments_count") @Expose var commentsCount: Long,
    @SerializedName("attachments_count") @Expose var attachmentsCount: Long,
    @SerializedName("rebounds_count") @Expose var reboundsCount: Long,
    @SerializedName("buckets_count") @Expose var bucketsCount: Long,
    @SerializedName("created_at") @Expose var createdAt: Date,
    @SerializedName("updated_at") @Expose var updatedAt: Date,
    @SerializedName("html_url") @Expose var htmlUrl: String,
    @SerializedName("attachments_url") @Expose var attachmentsUrl: String,
    @SerializedName("buckets_url") @Expose var bucketsUrl: String,
    @SerializedName("comments_url") @Expose var commentsUrl: String,
    @SerializedName("likes_url") @Expose var likesUrl: String,
    @SerializedName("projects_url") @Expose var projectsUrl: String,
    @SerializedName("rebounds_url") @Expose var reboundsUrl: String,
    @SerializedName("tags") @Expose var tags: Array<String>) {

}