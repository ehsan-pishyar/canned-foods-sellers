package ir.androad.repository.data_source

import ir.androad.cache.daos.LocationDao
import ir.androad.domain.models.Location
import ir.androad.domain.models.responses.CityResponse
import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.models.responses.StateResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.models.responses.CityResponseDto
import ir.androad.network.models.responses.LocationResponseDto
import ir.androad.network.models.responses.StateResponseDto
import ir.androad.network.services.LocationApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toDto
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDao: LocationDao
): LocationRepository {

    override fun getStates(): Flow<ServiceResult<List<StateResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteStates = try {
            locationApiService.getStates()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as StateResponseDto

        remoteStates.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override suspend fun getStateById(stateId: Int): ServiceResult<StateResponse> {
        TODO("Not yet implemented")
    }

    override fun getStatesByTitle(stateTitle: String?): Flow<ServiceResult<List<StateResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteStates = try {
            locationApiService.getStatesByTitle(stateTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as StateResponseDto

        remoteStates.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override fun getCities(stateId: Int): Flow<ServiceResult<List<CityResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteCities = try {
            locationApiService.getCities(stateId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as CityResponseDto

        remoteCities.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override suspend fun getCityById(stateId: Int, cityId: Int): ServiceResult<CityResponse> {
        val remoteCity = try {
            locationApiService.getCityById(stateId, cityId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteCity.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getCitiesByTitle(cityTitle: String?): Flow<ServiceResult<List<CityResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteCities = try {
            locationApiService.getCitiesByTitle(cityTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as CityResponseDto

        remoteCities.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override suspend fun insertLocation(location: Location): ServiceResult<Boolean> {
        val locationEntity = location.toEntity()
        val locationDto = locationEntity.toDto()

        val remoteLocation = try {
            locationApiService.insertLocation(locationDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        }

        remoteLocation.let {
            locationDao.insertLocation(it.toEntity())
            return ServiceResult.Success(data = true)
        }
    }

    override fun getLocations(cityId: Int): Flow<ServiceResult<List<LocationResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteLocations = try {
            locationApiService.getLocations(cityId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as LocationResponseDto

        remoteLocations.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override suspend fun getLocationById(locationId: Long): ServiceResult<LocationResponse> {
        val remoteLocation = try {
            locationApiService.getLocationById(locationId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteLocation.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getLocationsByTitle(locationTitle: String?): Flow<ServiceResult<List<LocationResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteLocations = try {
            locationApiService.getLocationsByTitle(locationTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as LocationResponseDto

        remoteLocations.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override suspend fun updateLocation(
        locationId: Long,
        location: Location
    ): ServiceResult<Boolean> {
        val locationEntity = location.toEntity()
        val locationDto = locationEntity.toDto()

        val remoteLocation = try {
            locationApiService.updateLocation(locationId, locationDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteLocation.let {
            locationDao.updateLocation(locationId, it.toEntity())
            return ServiceResult.Success(data = true)
        }
    }
}