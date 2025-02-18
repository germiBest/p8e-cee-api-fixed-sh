package io.provenance.onboarding.domain.objectStore

import com.google.protobuf.Message
import io.provenance.api.models.eos.StoreProtoResponse
import io.provenance.scope.encryption.proto.Encryption
import io.provenance.scope.objectstore.client.OsClient
import java.security.PrivateKey
import java.security.PublicKey

interface ObjectStore {
    fun getDIME(client: OsClient, hash: ByteArray, publicKey: PublicKey): Encryption.DIME
    fun retrieve(client: OsClient, hash: ByteArray, publicKey: PublicKey): ByteArray
    fun retrieveWithDIME(client: OsClient, hash: ByteArray, publicKey: PublicKey): Pair<Encryption.DIME, ByteArray>
    fun retrieveAndDecrypt(client: OsClient, hash: ByteArray, publicKey: PublicKey, privateKey: PrivateKey): ByteArray
    fun storeMessage(client: OsClient, message: Message, publicKey: PublicKey, additionalAudiences: Set<PublicKey>): StoreProtoResponse
}
