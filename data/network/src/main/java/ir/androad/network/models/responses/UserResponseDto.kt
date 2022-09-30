package ir.androad.network.models.responses

import ir.androad.network.models.ResponseErrorsDto
import ir.androad.network.models.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto(
    val user: UserDto?,
    val errors: List<ResponseErrorsDto?>?
)