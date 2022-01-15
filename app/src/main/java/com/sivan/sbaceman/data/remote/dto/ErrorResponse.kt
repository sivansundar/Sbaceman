package com.sivan.sbaceman.data.remote.dto

data class ErrorResponse(
    val message: String,
    val name: String,
    val status: Int
)
