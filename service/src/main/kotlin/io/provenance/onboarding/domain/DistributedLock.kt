package io.provenance.onboarding.domain

import java.util.UUID

interface DistributedLock {
    suspend fun <T> withSuspendLock(uuid: UUID, lockedBlock: suspend () -> T): T
    fun <T> withLock(uuid: UUID, lockedBlock: () -> T): T
}
