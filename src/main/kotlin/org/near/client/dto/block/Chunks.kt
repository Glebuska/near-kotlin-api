package org.near.client.dto.block

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Chunks(
    @SerialName("balance_burnt") val balanceBurnt: String,
    @SerialName("chunk_hash") val chunkHash: String,
    @SerialName("encoded_length") val encodedLength: Int,
    @SerialName("encoded_merkle_root") val encodedMerkleRoot: String,
    @SerialName("gas_limit") val gasLimit: Long,
    @SerialName("gas_used") val gasUsed: Long,
    @SerialName("height_created") val heightCreated: Int,
    @SerialName("height_included") val heightIncluded: Int,
    @SerialName("outcome_root") val outcomeRoot: String,
    @SerialName("outgoing_receipts_root") val outgoingReceiptsRoot: String,
    @SerialName("prev_block_hash") val prevBlockHash: String,
    @SerialName("prev_state_root") val prevStateRoot: String,
    @SerialName("rent_paid") val rentPaid: String,
    @SerialName("shard_id") val shardId: Int,
    @SerialName("signature") val signature: String,
    @SerialName("tx_root") val txRoot: String,
    @SerialName("validator_proposals") val validatorProposals: ArrayList<String>,
    @SerialName("validator_reward") val validatorReward: String,
)
