package ir.androad.domain.use_cases.result

import ir.androad.domain.models.responses.ResultDetailsResponse
import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult

class GetResultDetailsUseCase(
    private val resultRepository: ResultRepository
) {

    suspend operator fun invoke(resultId: Long): ServiceResult<ResultDetailsResponse> =
        resultRepository.getResultDetails(resultId)
}