package org.near.model

open class KeyPair {
    companion object {
        fun fromString(
            encodedSecretKey: String,
            encodedPublicKey: String,
        ): KeyPairEd25519 {
            val parts: List<String> = encodedSecretKey.split(':')
            when (parts.size) {
                1 -> {
                    return KeyPairEd25519(parts[0], encodedPublicKey)
                }
                2 -> {
                    when (parts[0].uppercase()) {
                        "ED25519" -> return KeyPairEd25519(parts[1], encodedPublicKey)
                        else -> {
                            throw Error("Unknown curve $parts[0]")
                        }
                    }
                }
                else -> {
                    throw Error("Invalid encoded key format, must be <curve>:<encoded key>")
                }
            }
        }
    }
}
