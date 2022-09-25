package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerResponseDto (
    val id: Long?,

    @SerialName("first_name")
    val firstName: String?,

    @SerialName("last_name")
    val lastName: String?,

    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: String?,

    @SerialName("date_created")
    val dateCreated: String?
)

@Serializable
data class CustomerDetailsResponseDto (
    val id: Long?,

    @SerialName("first_name")
    val firstName: String?,

    @SerialName("last_name")
    val lastName: String?,

    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: LocationResponseDto?,

    @SerialName("date_created")
    val dateCreated: String?
)