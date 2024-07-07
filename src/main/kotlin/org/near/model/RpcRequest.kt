package org.near.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.near.Params

@Serializable
data class RpcRequest(
    @SerialName("jsonrpc") val jsonRpc: String,
    val id: String,
    val method: String,
    val params: Params,
)
