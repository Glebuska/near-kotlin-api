package org.near.model

class KeyPairEd25519(
    ed25519SecretKey: String,
    ed25519PublicKey: String,
) : KeyPair() {
    var publicKey: PublicKey
    private var secretKey: String
    private var data: ByteArray

    init {
        val publicKeyAsBytes = Base58.decode(ed25519PublicKey)
        this.data = Base58.decode(ed25519SecretKey)
        this.publicKey = PublicKey(KeyType.ED25519, publicKeyAsBytes)
        this.secretKey = ed25519SecretKey
    }
}
