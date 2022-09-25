package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_STATE)
data class StateEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,

    val title: String = ""
)

@Entity(tableName = Constants.ENTITY_CITY)
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,

    val title: String = "",

    @ColumnInfo(name = "state_id")
    val stateId: Int = 0
)

@Entity(tableName = Constants.ENTITY_LOCATION)
data class LocationEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    val title: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,

    @ColumnInfo(name = "city_id")
    val cityId: Int = 0
)