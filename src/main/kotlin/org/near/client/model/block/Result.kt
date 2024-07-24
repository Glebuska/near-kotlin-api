package org.near.client.model.block

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val author: String,
    val chunks: ArrayList<Chunks>,
    val header: Header,
)
