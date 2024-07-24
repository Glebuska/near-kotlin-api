package org.near.model

import com.syntifi.crypto.key.encdec.Base58
import com.syntifi.near.borshj.Borsh
import com.syntifi.near.borshj.annotation.BorshField

data class PublicKey(
    @BorshField(order = 1)
    val keyType: KeyType,
    @BorshField(order = 2)
    val data: ByteArray,
) : Borsh {
    override fun toString(): String {
        val publicKey = Base58.encode(this.data)
        return "${this.keyTypeToStr(this.keyType)}:$publicKey"
    }

    private fun keyTypeToStr(kType: KeyType): String  {
        when (kType) {
            KeyType.ED25519 -> return "ed25519"
            else -> {
                throw Error("Unknown key type $kType")
            }
        }
    }
}

enum class KeyType {
    ED25519,
}
