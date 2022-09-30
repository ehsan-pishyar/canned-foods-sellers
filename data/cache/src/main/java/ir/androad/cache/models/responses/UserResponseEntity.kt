package ir.androad.cache.models.responses

import ir.androad.cache.models.ResponseErrorsEntity
import ir.androad.cache.models.UserEntity

data class UserResponseEntity(
    val user: UserEntity?,
    val errors: List<ResponseErrorsEntity?>?
)
