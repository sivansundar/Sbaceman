package com.sivan.sbaceman.domain.model

data class SearchOptions(
    val search_params: SearchParams
)

data class SearchParams(
    val title: String,
    val state: String
)
