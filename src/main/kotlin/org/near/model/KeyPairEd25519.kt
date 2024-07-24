package org.near.model

import com.syntifi.crypto.key.Ed25519PrivateKey
import com.syntifi.crypto.key.encdec.Base58
import kotlinx.serialization.Serializable

@Serializable
data class KeyPairEd25519(
    val secretKey: String,
    val publicKey: String,
) : KeyPair() {
    fun sign(message: ByteArray): ByteArray {
        val privateKey = Ed25519PrivateKey(Base58.decode(secretKey))
        return privateKey.sign(message)
    }
}
