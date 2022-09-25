package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.CityEntity
import ir.androad.cache.models.LocationEntity
import ir.androad.cache.models.StateEntity

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertState(stateEntity: StateEntity)

    @Query("SELECT * FROM `State_Table` WHERE id = :stateId")
    suspend fun fetchStateById(stateId: Int?): List<StateEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCity(cityEntity: CityEntity)

    @Query("SELECT * FROM `City_Table` WHERE state_id = :stateId AND id = :cityId")
    suspend fun fetchCityById(stateId: Int?, cityId: Int?): List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocation(locationEntity: LocationEntity)

    @Query("SELECT * FROM `Location_Table` WHERE id = :locationId")
    suspend fun fetchLocationById(locationId: Long?): LocationEntity

    @Update(entity = LocationEntity::class)
    suspend fun updateLocation(locationId: Long?, locationEntity: LocationEntity)

    @Query("DELETE FROM `Location_Table` WHERE id = :locationId")
    suspend fun deleteLocationById(locationId: Long?)
}