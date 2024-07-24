package org.near.model

import com.syntifi.crypto.key.encdec.Base58
import com.syntifi.crypto.key.hash.Sha256
import com.syntifi.near.borshj.Borsh
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.inject
import org.near.client.NearJsonRpcClient
import org.near.client.model.transaction.TransactionResponse
import java.math.BigInteger
import java.util.Base64

class Account(
    private val accountId: String,
    private val networkId: String,
    private val rcpEndpoint: String,
    private val keyPair: KeyPairEd25519,
) : KoinComponent {
    val client: NearJsonRpcClient by inject(NearJsonRpcClient::class.java)
    private val HARD_CODED_FOR_CONVERTING_NEAR_VALUE = "1000000000000000000000000"

    suspend fun sendMoney(
        receiverId: String,
        amount: String,
    ): TransactionResponse? {
        val actions = listOf(TransferAction(amount.convertAmountForSendingNear()))
        return this.signAndSendTransaction(receiverId, actions, "send_tx")
    }

    private suspend fun signAndSendTransaction(
        receiverId: String,
        actions: Collection<Action>,
        method: String,
    ): TransactionResponse? {
        val signedTransaction = signTransaction(receiverId, actions)

        val borshTx = Borsh.serialize(signedTransaction)
        val signTxBase64 = Base64.getEncoder().encodeToString(borshTx)

        return client.sendTransaction(method, signTxBase64)
    }

    private suspend fun signTransaction(
        receiverId: String,
        actions: Collection<Action>,
    ): SignedTransaction {
        val viewAccessKeyRsp = client.viewAccessKey(accountId, keyPair.publicKey)

        val nonce = viewAccessKeyRsp.result.nonce
        val headerHash = Base58.decode(viewAccessKeyRsp.result.blockHash)

        val nextNonce = nonce + 1L
        val pubKey = this.keyPair.publicKey

        val publicKey = PublicKey(KeyType.ED25519, Base58.decode(pubKey))

        val transaction =
            Transaction(
                accountId,
                publicKey,
                nextNonce,
                receiverId,
                headerHash,
                actions,
            )

        val serializedTx: ByteArray = Borsh.serialize(transaction)
        val hashedTx: ByteArray = Sha256.digest(serializedTx)
        val signedTx: ByteArray = keyPair.sign(hashedTx)

        return SignedTransaction(
            transaction,
            Signature(KeyType.ED25519, signedTx),
        )
    }

    fun String.convertAmountForSendingNear(): BigInteger {
        val inputNear = this.toBigDecimal()
        val constValueInBI = HARD_CODED_FOR_CONVERTING_NEAR_VALUE.toBigDecimal()
        return (inputNear * constValueInBI).toBigInteger()
    }
}
