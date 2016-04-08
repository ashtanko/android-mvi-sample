package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class User(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("username") @Expose var username: String,
    @SerializedName("html_url") @Expose var html_url: String,
    @SerializedName("avatar_url") @Expose var avatarUrl: String,
    @SerializedName("bio") @Expose var bio: String,
    @SerializedName("location") @Expose var location: String,
    @SerializedName("links") @Expose var links: Map<String, String>,
    @SerializedName("buckets_count") @Expose var bucketsCount: Long,
    @SerializedName("comments_received_count") @Expose var commentsReceivedCount: Long,
    @SerializedName("followers_count") @Expose var followersCount: Long,
    @SerializedName("followings_count") @Expose var followingsCount: Long,
    @SerializedName("likes_count") @Expose var likes_count: Long,
    @SerializedName("likes_received_count") @Expose var likesReceivedCount: Long,
    @SerializedName("projects_count") @Expose var projectsCount: Long,
    @SerializedName("rebounds_received_count") @Expose var reboundsReceivedCount: Long,
    @SerializedName("shots_count") @Expose var shotsCount: Long,
    @SerializedName("teams_count") @Expose var teamsCount: Long,
    @SerializedName("can_upload_shot") @Expose var canUploadShot: Boolean,
    @SerializedName("type") @Expose var type: String,
    @SerializedName("pro") @Expose var pro: Boolean,
    @SerializedName("buckets_url") @Expose var bucketsUrl: String,
    @SerializedName("followers_url") @Expose var followersUrl: String,
    @SerializedName("following_url") @Expose var followingUrl: String,
    @SerializedName("likes_url") @Expose var likesUrl: String,
    @SerializedName("shots_url") @Expose var shotsUrl: String,
    @SerializedName("teams_url") @Expose var teamsUrl: String,
    @SerializedName("created_at") @Expose var createdAt: Date,
    @SerializedName("updated_at") @Expose var updatedAt: Date) {

}