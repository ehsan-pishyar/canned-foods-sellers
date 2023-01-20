package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.StateResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult

class GetStateByIdUseCase(
    private val locationRepository: LocationRepository
) {

    suspend operator fun invoke(stateId: Int): ServiceResult<StateResponse> =
        locationRepository.getStateById(stateId)
}