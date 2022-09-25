package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto (
    val id: Long?,
    val email: String?,
    val password: String?,

    @SerialName("user_type")
    val userType: String?,

    @SerialName("date_created")
    val dateCreated: String?,
)