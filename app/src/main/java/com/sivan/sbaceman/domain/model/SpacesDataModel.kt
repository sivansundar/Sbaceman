package com.sivan.sbaceman.domain.model

data class SpacesDataModel(
    val host_ids: List<String>,
    val id: String,
    val scheduled_start: String,
    val state: String,
    val title: String
)

data class UserModel(
    val id: String,
    val name: String,
    val profile_image_url: String,
    val public_metrics: PublicMetricsModel,
    val username: String
)

data class PublicMetricsModel(
    val followers_count: Int,
    val following_count: Int,
    val listed_count: Int,
    val tweet_count: Int
)
