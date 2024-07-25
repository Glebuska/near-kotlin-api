package org.near.client.dto.block

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val author: String,
    val chunks: ArrayList<Chunks>,
    val header: Header,
)
