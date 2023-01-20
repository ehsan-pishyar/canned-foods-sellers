package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.LocationResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult

class GetLocationByIdUseCase(
    private val locationRepository: LocationRepository
) {

    suspend operator fun invoke(locationId: Long): ServiceResult<LocationResponse> =
        locationRepository.getLocationById(locationId)
}