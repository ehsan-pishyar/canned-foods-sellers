package ir.androad.network.models.responses

import ir.androad.network.models.ResponseErrors
import ir.androad.network.models.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto(
    @SerialName("user")
    val userDto: UserDto?,
    val errors: List<ResponseErrors?>?
)