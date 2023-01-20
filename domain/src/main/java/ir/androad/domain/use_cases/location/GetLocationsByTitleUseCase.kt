package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetLocationsByTitleUseCase(
    private val locationRepository: LocationRepository
) {

    operator fun invoke(locationTitle: String?): Flow<ServiceResult<List<LocationResponse>?>> =
        locationRepository.getLocationsByTitle(locationTitle)
}