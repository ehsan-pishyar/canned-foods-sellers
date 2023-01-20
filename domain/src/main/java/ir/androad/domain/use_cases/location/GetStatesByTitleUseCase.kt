package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.StateResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetStatesByTitleUseCase(
    private val locationRepository: LocationRepository
) {

    operator fun invoke(locationTitle: String?): Flow<ServiceResult<List<StateResponse>?>> =
        locationRepository.getStatesByTitle(locationTitle)
}