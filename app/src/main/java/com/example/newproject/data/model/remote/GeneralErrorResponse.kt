package com.example.newproject.data.model.remote

data class GeneralErrorResponse(
    val message: String?,
    val error: String?,
    val statusCode: Int?
)