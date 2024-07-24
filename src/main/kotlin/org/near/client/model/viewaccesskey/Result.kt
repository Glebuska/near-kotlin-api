package org.near.client.model.viewaccesskey

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("block_hash") val blockHash: String,
    @SerialName("block_height") val blockHeight: Long,
    @SerialName("nonce") val nonce: Long,
    @SerialName("permission") val permission: String,
)
