package org.near.client.dto.block

import kotlinx.serialization.Serializable
import org.near.client.dto.ErrorResponse

@Serializable
data class Block(
    val jsonrpc: String,
    val result: Result?,
    val id: String,
    val error: ErrorResponse?,
)
