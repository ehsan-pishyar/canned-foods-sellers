package ir.androad.repository.data_source

import ir.androad.domain.models.Location
import ir.androad.domain.models.responses.CityResponse
import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.models.responses.StateResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.ApiService
import ir.androad.network.models.responses.CityResponseDto
import ir.androad.network.models.responses.LocationResponseDto
import ir.androad.network.models.responses.StateResponseDto
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): LocationRepository {

    override suspend fun getStates(): ServiceResult<List<StateResponse>?> {
        val remoteStates = try {
            apiService.getStates()
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteStates.let {
            return ServiceResult.Success(data = listOf(it.toEntity().toDomain()))
        }
    }

    override suspend fun getStateById(stateId: Int): ServiceResult<StateResponse> {
        val remoteState = try {
            apiService.getStateById(stateId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteState.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getStatesByTitle(stateTitle: String?): Flow<ServiceResult<List<StateResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteStates = try {
            apiService.getStatesByTitle(stateTitle)
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
            apiService.getCities(stateId)
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
            apiService.getCityById(stateId, cityId)
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
            apiService.getCitiesByTitle(cityTitle)
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

    override fun getLocations(cityId: Int): Flow<ServiceResult<List<LocationResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteLocations = try {
            apiService.getLocations(cityId)
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
            apiService.getLocationById(locationId)
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
            apiService.getLocationsByTitle(locationTitle)
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
        TODO("Not yet implemented")
    }
}