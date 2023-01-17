package ir.androad.domain.use_cases.result

import ir.androad.domain.models.responses.ResultResponse
import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetResultsUseCase(
    private val resultRepository: ResultRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<ResultResponse>?>> =
        resultRepository.getResults()
}