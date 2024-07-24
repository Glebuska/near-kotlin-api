package org.near.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpcRequest(
    @SerialName("jsonrpc")
    val jsonRpc: String,
    @SerialName("id")
    val id: String,
    @SerialName("method")
    val method: String,
    val params: RequestParams,
)
