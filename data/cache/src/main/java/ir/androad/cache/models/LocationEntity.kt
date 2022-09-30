package ir.androad.cache.models

data class StateEntity(
    val id: Int?,
    val title: String?
)

data class CityEntity(
    val id: Int?,
    val title: String?,
    val stateId: Int?
)

data class LocationEntity(
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val cityId: Int?
)