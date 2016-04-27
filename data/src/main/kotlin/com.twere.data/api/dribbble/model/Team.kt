package com.twere.data.api.dribbble.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id") @Expose var id: Long,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("username") @Expose var username: String,
    @SerializedName("html_url") @Expose var htmlUrl: String,
    @SerializedName("avatar_url") @Expose var avatarUrl: String,
    @SerializedName("bio") @Expose var bio: String,
    @SerializedName("location") @Expose var location: String,
    @SerializedName("buckets_count") @Expose var bucketsCount: Long,
    @SerializedName("comments_received_count") @Expose var commentsReceivedCount: Long,
    @SerializedName("followers_count") @Expose var followersCount: Long,
    @SerializedName("followings_count") @Expose var followingsCount: Long,
    @SerializedName("likes_count") @Expose var likesCount: Long,
    @SerializedName("likes_received_count") @Expose var likesReceivedCount: Long) {
}