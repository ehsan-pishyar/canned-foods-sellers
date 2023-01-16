package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ir.androad.cache.models.responses.LocationResponseEntity

@Dao
interface LocationDao {

    @Insert
    suspend fun insertLocation(locationResponseEntity: LocationResponseEntity)

    @Query("SELECT * FROM `Location_Table` WHERE id = :locationId")
    suspend fun fetchLocationById(locationId: Long): LocationResponseEntity

    @Update
    suspend fun updateLocation(locationId: Long, locationResponseEntity: LocationResponseEntity)
}