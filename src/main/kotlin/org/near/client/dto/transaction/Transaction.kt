package org.near.client.dto.transaction

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.near.client.dto.ErrorResponse

@Serializable
data class TransactionResponse(
    @SerialName("jsonrpc")
    val jsonRpc: String,
    @SerialName("result")
    val result: Result,
    @SerialName("id")
    val id: String,
    @SerialName("error")
    val error: ErrorResponse?,
)

@Serializable
data class Result(
    @SerialName("final_execution_status") val finalExecutionStatus: String,
    @SerialName("status") val status: Status,
    @SerialName("transaction") val transaction: Transaction,
    @SerialName("transaction_outcome") val transactionOutcome: TransactionOutcome,
    @SerialName("receipts_outcome") val receiptsOutcome: List<ReceiptOutcome>,
)

@Serializable
data class Status(
    @SerialName("SuccessValue") val successValue: String,
)

@Serializable
data class Transaction(
    @SerialName("signer_id") val signerId: String,
    @SerialName("public_key") val publicKey: String,
    @SerialName("nonce") val nonce: Long,
    @SerialName("receiver_id") val receiverId: String,
    @SerialName("actions") val actions: List<Action>,
    @SerialName("signature") val signature: String,
    @SerialName("hash") val hash: String,
)

@Serializable
data class Action(
    @SerialName("Transfer") val transfer: Transfer,
)

@Serializable
data class Transfer(
    @SerialName("deposit") val deposit: String,
)

@Serializable
data class TransactionOutcome(
    @SerialName("proof") val proof: List<Proof>,
    @SerialName("block_hash") val blockHash: String,
    @SerialName("id") val id: String,
    @SerialName("outcome") val outcome: Outcome,
)

@Serializable
data class Outcome(
    @SerialName("logs") val logs: List<String>,
    @SerialName("receipt_ids") val receiptIds: List<String>,
    @SerialName("gas_burnt") val gasBurnt: Long,
    @SerialName("tokens_burnt") val tokensBurnt: String,
    @SerialName("executor_id") val executorId: String,
    @SerialName("status") val status: OutcomeStatus,
    @SerialName("metadata") val metadata: Metadata,
)

@Serializable
data class Metadata(
    @SerialName("gas_profile") val gasProfile: List<String>?,
    @SerialName("version") val version: Long,
)

@Serializable
data class OutcomeStatus(
    @SerialName("SuccessValue") val successValue: String? = null,
    @SerialName("SuccessReceiptId") val successReceiptId: String? = null,
)

@Serializable
data class ReceiptOutcome(
    @SerialName("proof") val proof: List<Proof>,
    @SerialName("block_hash") val blockHash: String,
    @SerialName("id") val id: String,
    @SerialName("outcome") val outcome: Outcome,
)

@Serializable
data class Proof(
    val hash: String,
    val direction: String,
)
