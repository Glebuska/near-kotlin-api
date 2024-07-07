package org.near.service

import io.ktor.client.*
import java.math.BigInteger

class ServiceImpl(
    private val client: HttpClient,
) {
    suspend fun sendMoney(
        receiverId: String,
        amount: BigInteger,
    ) {
    }

//    private fun signAndSendTransaction()
}
