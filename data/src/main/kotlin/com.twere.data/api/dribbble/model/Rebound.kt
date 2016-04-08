package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Rebound(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("title") @Expose var title: String,
    @SerializedName("description") @Expose var description: String,
    @SerializedName("width") @Expose var width: Int,
    @SerializedName("height") @Expose var height: Int,
    @SerializedName("images") @Expose var images: Images,
    @SerializedName("views_count") @Expose var viewsCount: Int,
    @SerializedName("likes_count") @Expose var likesCount: Int,
    @SerializedName("comments_count") @Expose var commentsCount: Int,
    @SerializedName("attachments_count") @Expose var attachmentsCount: Int,
    @SerializedName("rebounds_count") @Expose var reboundsCount: Int,
    @SerializedName("buckets_count") @Expose var bucketsCount: Int,
    @SerializedName("created_at") @Expose var createdAt: Date,
    @SerializedName("updated_at") @Expose var updatedAt: Date,
    @SerializedName("html_url") @Expose var htmlUrl: String,
    @SerializedName("attachments_url") @Expose var attachmentsUrl: String,
    @SerializedName("comments_url") @Expose var commentsUrl: String,
    @SerializedName("likes_url") @Expose var likesUrl: String,
    @SerializedName("projects_url") @Expose var projectsUrl: String,
    @SerializedName("rebounds_url") @Expose var reboundsUrl: String,
    @SerializedName("rebound_source_url") @Expose var reboundSourceUrl: String,
    @SerializedName("tags") @Expose var tags: Array<Int>, //TODO
    @SerializedName("user") @Expose var user: User,
    @SerializedName("team") @Expose var team: Team) {

}