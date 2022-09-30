package ir.androad.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseErrorsDto(
    val code: String?,
    val message: String?
)
