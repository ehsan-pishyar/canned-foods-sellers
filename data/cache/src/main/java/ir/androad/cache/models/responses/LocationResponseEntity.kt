package ir.androad.cache.models.responses

import ir.androad.cache.models.CityEntity

data class StateResponse(
    val id: Int?,
    val title: String?,
    val cities: CityEntity?
)

data class CityResponse(
    val id: Int?,
    val title: String?,
    val state: String?
)

data class LocationResponse(
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val city: String?,
    val state: String?
)