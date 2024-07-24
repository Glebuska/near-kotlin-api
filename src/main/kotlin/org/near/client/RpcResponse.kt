package org.near.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.near.Result

@Serializable
data class RpcResponse(
    @SerialName("jsonrpc") val jsonRpc: String,
    val result: Result,
    val id: String,
)
