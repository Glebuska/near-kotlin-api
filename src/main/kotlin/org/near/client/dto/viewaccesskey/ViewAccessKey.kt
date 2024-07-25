package org.near.client.dto.viewaccesskey

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.near.client.dto.ErrorResponse

@Serializable
data class ViewAccessKey(
    @SerialName("jsonrpc") val jsonrpc: String,
    @SerialName("result") val result: Result,
    @SerialName("id") val id: String,
    @SerialName("error") val error: ErrorResponse?,
)
