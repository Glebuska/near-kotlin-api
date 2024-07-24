package org.near.model

import kotlinx.serialization.Serializable
import org.near.client.model.ErrorResponse

@Serializable
data class SendMoney(
    val jsonrpc: String,
    val result: String,
    val id: String?,
    val error: ErrorResponse?,
)
