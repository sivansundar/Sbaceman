package com.sivan.sbaceman.data.remote.dto

data class SpacesResponse(
    val `data`: SpaceResult,
    val status: Int
)

data class SpaceResult(
    val space_data: List<SpaceData>,
    val users: List<User>
)

data class SpaceData(
    val host_ids: List<String>,
    val id: String,
    val scheduled_start: String,
    val state: String,
    val title: String
)

data class User(
    val id: String,
    val name: String,
    val profile_image_url: String,
    val public_metrics: PublicMetrics,
    val username: String
)

data class PublicMetrics(
    val followers_count: Int,
    val following_count: Int,
    val listed_count: Int,
    val tweet_count: Int
)
