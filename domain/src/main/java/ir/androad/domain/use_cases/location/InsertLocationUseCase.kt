package ir.androad.domain.use_cases.location

import ir.androad.domain.models.Location
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult

class InsertLocationUseCase(
    private val locationRepository: LocationRepository
) {

    suspend operator fun invoke(location: Location): ServiceResult<Boolean> =
        locationRepository.insertLocation(location)
}