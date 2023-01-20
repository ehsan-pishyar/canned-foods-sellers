package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.CityResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult

class GetCityByIdUseCase(
    private val locationRepository: LocationRepository
) {

    suspend operator fun invoke(stateId: Int, cityId: Int): ServiceResult<CityResponse> =
        locationRepository.getCityById(stateId, cityId)
}