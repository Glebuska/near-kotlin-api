package org.near.model

import com.syntifi.near.borshj.annotation.BorshField
import org.near.borshj.Borsh
import sun.security.rsa.RSAUtil

class PublicKey(
    kType: KeyType,
    publicKey: ByteArray,
) : Borsh {
    @BorshField(order = 1)
    var keyType: RSAUtil.KeyType = kType

    @BorshField(order = 2)
    var data: ByteArray = publicKey
}
