package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerDto(
    val id: Long?,

    @SerialName("user_id")
    val userId: Long?,

    @SerialName("first_name")
    val firstName: String?,

    @SerialName("last_name")
    val lastName: String?,

    val email: String?,
    val picture: String?,

    @SerialName("phone_number")
    val phoneNumber: Long?,

    @SerialName("location_id")
    val locationId: Long?,

    val sex: String?,

    @SerialName("birth_date")
    val birthDate: String?,

    @SerialName("date_created")
    val dateCreated: String?
)
