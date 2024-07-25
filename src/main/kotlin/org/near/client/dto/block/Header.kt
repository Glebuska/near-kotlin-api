package org.near.client.dto.block

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Header(
    @SerialName("approvals") val approvals: ArrayList<String>,
    @SerialName("block_merkle_root") val blockMerkleRoot: String,
    @SerialName("block_ordinal") val blockOrdinal: Int,
    @SerialName("challenges_result") val challengesResult: ArrayList<String>,
    @SerialName("challenges_root") val challengesRoot: String,
    @SerialName("chunk_headers_root") val chunkHeadersRoot: String,
    @SerialName("chunk_mask") val chunkMask: ArrayList<Boolean>,
    @SerialName("chunk_receipts_root") val chunkReceiptsRoot: String,
    @SerialName("chunk_tx_root") val chunkTxRoot: String,
    @SerialName("chunks_included") val chunksIncluded: Int,
    @SerialName("epoch_id") val epochId: String,
    @SerialName("epoch_sync_data_hash") val epochSyncDataHash: String,
    @SerialName("gas_price") val gasPrice: String,
    @SerialName("hash") val hash: String,
    @SerialName("height") val height: Int,
    @SerialName("last_ds_final_block") val lastDsFinalBlock: String,
    @SerialName("last_final_block") val lastFinalBlock: String,
    @SerialName("latest_protocol_version") val latestProtocolVersion: Int,
    @SerialName("next_bp_hash") val nextBpHash: String,
    @SerialName("next_epoch_id") val nextEpochId: String,
    @SerialName("outcome_root") val outcomeRoot: String,
    @SerialName("prev_hash") val prevHash: String,
    @SerialName("prev_height") val prevHeight: Int,
    @SerialName("prev_state_root") val prevStateRoot: String,
    @SerialName("random_value") val randomValue: String,
    @SerialName("rent_paid") val rentPaid: String,
    @SerialName("signature") val signature: String,
    @SerialName("timestamp") val timestamp: Long,
    @SerialName("timestamp_nanosec") val timestampNanosec: String,
    @SerialName("total_supply") val totalSupply: String,
    @SerialName("validator_proposals") val validatorProposals: ArrayList<String>,
    @SerialName("validator_reward") val validatorReward: String,
)
