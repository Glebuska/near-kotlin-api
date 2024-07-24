package org.near.model

import com.syntifi.near.borshj.Borsh
import com.syntifi.near.borshj.annotation.BorshSubTypes

@BorshSubTypes(
    BorshSubTypes.BorshSubType(`when` = Action.TRANSFER.toInt(), use = TransferAction::class),
)
interface Action : Borsh {
    companion object {
        const val CREATE_ACCOUNT: Byte = 0
        const val DEPLOY_CONTRACT: Byte = 1
        const val FUNCTION_CALL: Byte = 2
        const val TRANSFER: Byte = 3
        const val STAKE: Byte = 4
        const val ADD_KEY: Byte = 5
        const val DELETE_KEY: Byte = 6
        const val DELETE_ACCOUNT: Byte = 7
    }
}
