package org.near

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin
import org.koin.java.KoinJavaComponent.inject
import org.near.client.dto.RequestParams
import org.near.client.dto.RpcRequest
import org.near.di.module
import org.near.model.Account
import org.near.model.KeyPairEd25519

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
    val secretKey = System.getenv("SECRET_KEY")
    val publicKey = System.getenv("PUBLIC_KEY")
    val keyPairEd25519 =
        KeyPairEd25519(
            secretKey,
            publicKey,
        )

    val account = Account(accountId, "todo", "todo", keyPairEd25519)
    val res = account.sendMoney(accountId, "0.5")

    println(res)

    client.close()
    stopKoin()
}
