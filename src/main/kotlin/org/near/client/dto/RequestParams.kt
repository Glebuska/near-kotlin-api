package org.near.client.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestParams(
    @SerialName("finality")
    val finality: String? = null,
    @SerialName("block_id")
    val blockId: String? = null,
    @SerialName("request_type")
    val requestType: String? = null,
    @SerialName("account_id")
    val accountId: String? = null,
    @SerialName("public_key")
    val publicKey: String? = null,
    @SerialName("method_name")
    val methodName: String? = null,
    @SerialName("args_base64")
    val argsBase64: String? = null,
    @SerialName("signed_tx_base64")
    val signedTxBase64: String? = null,
    @SerialName("wait_until")
    val waitUntil: String? = null,
)
