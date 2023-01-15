package ir.androad.domain.repositories

import ir.androad.domain.models.Location
import ir.androad.domain.models.responses.CityResponse
import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.models.responses.StateResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    suspend fun getStates(): ServiceResult<List<StateResponse>?>
    suspend fun getStateById(stateId: Int): ServiceResult<StateResponse>
    fun getStatesByTitle(stateTitle: String?): Flow<ServiceResult<List<StateResponse>?>>

    fun getCities(stateId: Int): Flow<ServiceResult<List<CityResponse>?>>
    suspend fun getCityById(stateId: Int, cityId: Int): ServiceResult<CityResponse>
    fun getCitiesByTitle(cityTitle: String?): Flow<ServiceResult<List<CityResponse>?>>

    fun getLocations(cityId: Int): Flow<ServiceResult<List<LocationResponse>?>>
    suspend fun getLocationById(locationId: Long): ServiceResult<LocationResponse>
    fun getLocationsByTitle(locationTitle: String?): Flow<ServiceResult<List<LocationResponse>?>>
    suspend fun updateLocation(locationId: Long, location: Location): ServiceResult<Boolean>
}