package ir.androad.network.models.responses

import ir.androad.network.models.CityDto
import kotlinx.serialization.Serializable

@Serializable
data class StateResponseDto(
    val id: Int?,
    val title: String?,
    val cities: CityDto?
)

@Serializable
data class CityResponseDto(
    val id: Int?,
    val title: String?,
    val state: String?
)

@Serializable
data class LocationResponseDto(
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val city: String?,
    val state: String?
)