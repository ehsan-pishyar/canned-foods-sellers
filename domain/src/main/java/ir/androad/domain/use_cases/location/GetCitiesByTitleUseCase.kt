package ir.androad.domain.use_cases.location

import ir.androad.domain.models.responses.CityResponse
import ir.androad.domain.repositories.LocationRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetCitiesByTitleUseCase(
    private val locationRepository: LocationRepository
) {

    operator fun invoke(cityTitle: String?): Flow<ServiceResult<List<CityResponse>?>> =
        locationRepository.getCitiesByTitle(cityTitle)
}