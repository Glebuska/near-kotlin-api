package org.near.model

import com.syntifi.near.borshj.annotation.BorshField
import java.math.BigInteger

data class TransferAction(
    @BorshField(order = 1)
    val depositValue: BigInteger,
) : Action
