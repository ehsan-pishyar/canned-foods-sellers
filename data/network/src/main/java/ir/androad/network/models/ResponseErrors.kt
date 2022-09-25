package ir.androad.network.models

import ir.androad.network.utils.ErrorCode
import kotlinx.serialization.Serializable

@Serializable
data class ResponseErrors(
    val code: ErrorCode,
    val message: String
)
