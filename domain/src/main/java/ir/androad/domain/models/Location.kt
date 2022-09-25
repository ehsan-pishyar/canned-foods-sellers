package ir.androad.domain.models

data class State(
    val id: Int?,
    val title: String?
)

data class City(
    val id: Int?,
    val title: String?,
    val stateId: Int?
)

data class Location(
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val cityId: Int?
)