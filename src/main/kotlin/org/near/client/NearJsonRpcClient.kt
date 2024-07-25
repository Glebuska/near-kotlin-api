package org.near.client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import org.near.client.dto.RequestParams
import org.near.client.dto.RpcRequest
import org.near.client.dto.block.Block
import org.near.client.dto.transaction.TransactionResponse
import org.near.client.dto.viewaccesskey.ViewAccessKey

class NearJsonRpcClient(
    private val client: HttpClient,
) {
    suspend fun block(): Block {
        val params = RequestParams(finality = "final")
        return doRequest("block", params).body()
    }

    suspend fun viewAccessKey(
        accountId: String,
        base58PublicKey: String,
    ): ViewAccessKey {
        val params =
            RequestParams(
                finality = "final",
                requestType = "view_access_key",
                accountId = accountId,
                publicKey = base58PublicKey,
            )
        return doRequest("query", params).body()
    }

    suspend fun sendTransaction(
        method: String,
        signedTxBase64: String,
    ): TransactionResponse? =
        doRequest(
            method,
            RequestParams(
                signedTxBase64 = signedTxBase64,
                waitUntil = "INCLUDED_FINAL",
            ),
        ).body()

    private suspend fun doRequest(
        method: String,
        params: RequestParams,
    ): HttpResponse {
        val request = RpcRequest("2.0", "dontcare", method = method, params = params)

        return client
            .post {
                setBody(request)
            }
    }
}
