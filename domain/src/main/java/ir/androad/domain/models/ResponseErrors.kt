package ir.androad.domain.models

import ir.androad.domain.utils.ErrorCode

data class ResponseErrors(
    val code: ErrorCode,
    val message: String
)
