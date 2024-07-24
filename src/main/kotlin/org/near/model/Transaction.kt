package org.near.model

import com.syntifi.near.borshj.Borsh
import com.syntifi.near.borshj.annotation.BorshField

data class Transaction(
    @BorshField(order = 1)
    val signerId: String,
    @BorshField(order = 2)
    val publicKey: PublicKey,
    @BorshField(order = 3)
    val nonce: Long,
    @BorshField(order = 4)
    val receiverId: String,
    @BorshField(order = 5)
    val blockHash: ByteArray,
    @BorshField(order = 6)
    val actions: Collection<Action>,
) : Borsh
