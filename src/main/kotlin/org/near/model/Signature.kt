package org.near.model

import com.syntifi.near.borshj.Borsh
import com.syntifi.near.borshj.annotation.BorshField

data class Signature(
    @BorshField(order = 1)
    val type: KeyType,
    @BorshField(order = 2)
    val data: ByteArray,
) : Borsh
