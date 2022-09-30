package ir.androad.domain.models.responses

import ir.androad.domain.models.ResponseErrors
import ir.androad.domain.models.User

data class UserResponse (
    val user: User?,
    val errors: List<ResponseErrors?>?
)