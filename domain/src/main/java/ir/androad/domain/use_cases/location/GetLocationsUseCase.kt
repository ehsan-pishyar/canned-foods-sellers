package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetLocationsUseCase(
    private val locationRepository: LocationRepository
) {

    operator fun invoke(cityId: Int): Flow<ServiceResult<List<LocationResponse>?>> =
        locationRepository.getLocations(cityId)
}