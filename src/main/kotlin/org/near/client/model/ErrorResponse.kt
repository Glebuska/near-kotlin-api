package org.near.client.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val cause: String,
    val code: Int,
    val data: String,
    val message: String,
    val name: String,
)
