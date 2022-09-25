package ir.androad.cache.models.responses

import ir.androad.cache.models.UserEntity

data class UserResponseEntity(
    val userEntity: UserEntity?,
    val errors: List<ResponseErrors> = emptyList()
)
