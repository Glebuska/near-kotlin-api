package org.near

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin
import org.koin.java.KoinJavaComponent.inject
import org.near.client.RequestParams
import org.near.client.RpcRequest
import org.near.di.module
import org.near.model.Account
import org.near.model.KeyPairEd25519

@Serializable
data class Params(
    @SerialName("request_type")
    val requestType: String,
    val finality: String,
    @SerialName("account_id")
    val accountId: String,
)

@Serializable
data class Result(
    val amount: String,
    @SerialName("block_hash")
    val blockHash: String,
    @SerialName("block_height")
    val blockHeight: Long,
    @SerialName("code_hash")
    val codeHash: String,
    val locked: String,
    @SerialName("storage_paid_at")
    val storagePaidAt: Int,
    @SerialName("storage_usage")
    val storageUsage: Int,
)

@Serializable
data class Action(
    @SerialName("method_name") val methodName: String,
    val args: String,
    val gas: Long,
    val deposit: Long,
)

@Serializable
data class Transaction(
    @SerialName("signer_id") val signerId: String,
    @SerialName("public_key") val publicKey: String,
    val nonce: Long,
    @SerialName("receiver_id") val receiverId: String,
    @SerialName("block_hash") val blockHash: String,
    val actions: List<Action>,
)

suspend fun main() {
    startKoin {
        modules(module)
    }

    val client: HttpClient by inject(HttpClient::class.java)

    val accountId = "gmirzazyanov.testnet"
    val dontCareId = "dontcare"
    // Example usage:
    val request =
        RpcRequest(
            jsonRpc = "2.0",
            id = dontCareId,
            method = "query",
            params =
                RequestParams(
                    requestType = "view_account",
                    finality = "optimistic",
                    accountId = accountId,
                ),
        )

    val response: String =
        client
            .post {
                setBody(request)
            }.bodyAsText()

    println(response)

    val keyPairEd25519 =
        KeyPairEd25519(
            "5DNCbmYxCTQHHq8tasJPRZ7GsLd8jr8U6jt95vyq95e5SY2ag1nK2ovmMWDG54oH3xMJC24vDMvrQKEgXMseUFbu",
            "A73A8VEZhCDajeg57DPmiP1kPFY8ESo4mj8knX8zuquH",
        )

    val account = Account(accountId, "todo", "todo", keyPairEd25519)
    val res = account.sendMoney(accountId, "0.5")

    println(res)

    client.close()
    stopKoin()
}

data class InMemorySigner(
    val accountId: String,
    val privateKey: String,
) {
    val publicKey: String
        get() = "public_key_placeholder" // Replace with actual public key logic

    fun sign(transaction: Transaction): Transaction {
        // Add signing logic here
        return transaction
    }
}
