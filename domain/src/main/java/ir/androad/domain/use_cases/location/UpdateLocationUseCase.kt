package ir.androad.domain.use_cases.location

import ir.androad.domain.models.Location
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult

class UpdateLocationUseCase(
    private val locationRepository: LocationRepository
) {

    suspend operator fun invoke(locationId: Long, location: Location): ServiceResult<Boolean> =
        locationRepository.updateLocation(locationId, location)
}