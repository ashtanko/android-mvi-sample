package com.twere.data

import com.twere.data.api.dribbble.model.Images
import java.util.Date

data class DribbleItem(
    val description: String,
    val width: Long,
    val height: Long,
    val images: Images,
    val views_count: Long,
    val likes_count: Long,
    val comments_count: Long,
    val attachments_count: Long,
    val rebounds_count: Long,
    val buckets_count: Long,
    val created_at: Date?,
    val updated_at: Date?,
    val html_url: String,
    val attachments_url: String,
    val buckets_url: String,
    val comments_url: String,
    val likes_url: String,
    val projects_url: String,
    val rebounds_url: String,
    val animated: Boolean,
    val tags: List<String>) {
}