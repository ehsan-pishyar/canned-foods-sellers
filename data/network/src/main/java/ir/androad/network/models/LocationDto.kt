package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StateDto(
    val id: Int?,
    val title: String?
)

@Serializable
data class CityDto(
    val id: Int?,
    val title: String?,

    @SerialName("state_id")
    val stateId: Int?
)

@Serializable
data class LocationDto(
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,

    @SerialName("city_id")
    val cityId: Int?
)