package org.near.client.model.block

import kotlinx.serialization.Serializable
import org.near.client.model.ErrorResponse

@Serializable
data class Block(
    val jsonrpc: String,
    val result: Result?,
    val id: String,
    val error: ErrorResponse?,
)
