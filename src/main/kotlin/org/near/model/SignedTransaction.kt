package org.near.model

import com.syntifi.near.borshj.Borsh
import com.syntifi.near.borshj.annotation.BorshField

data class SignedTransaction(
    @BorshField(order = 1)
    val transaction: Transaction,
    @BorshField(order = 2)
    val signature: Signature,
) : Borsh
