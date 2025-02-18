package io.provenance.onboarding.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hubspot.jackson.datatype.protobuf.ProtobufModule

private val debugObjectMapper by lazy {
    jacksonObjectMapper()
        .registerKotlinModule()
        .registerModule(ProtobufModule())
}

fun Any.toPrettyJson(): String = debugObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this)
