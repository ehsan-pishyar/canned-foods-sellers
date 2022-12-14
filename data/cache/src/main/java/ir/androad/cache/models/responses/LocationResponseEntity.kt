package ir.androad.cache.models.responses

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.models.CityEntity

data class StateResponseEntity (
    val id: Int?,
    val title: String?,
    val cities: CityEntity?
)

data class CityResponseEntity (
    val id: Int?,
    val title: String?,
    val state: String?
)

@Entity(tableName = "Location_Table")
data class LocationResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val title: String?,
    val lat: Double?,
    val lon: Double?,
    val city: String?,
    val state: String?
)