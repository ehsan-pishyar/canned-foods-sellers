package ir.androad.domain.models.responses

import ir.androad.domain.models.City

data class StateResponse (
    val id: Int?,
    val title: String?,
    val cities: City? // TODO: fix this shit
)

data class CityResponse (
    val id: Int?,
    val title: String?,
    val state: String?
)

data class LocationResponse (
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val city: String?,
    val state: String?
)