package ir.androad.domain.use_cases.result

import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.domain.models.Result

class UpdateResultUseCase(
    private val resultRepository: ResultRepository
) {

    suspend operator fun invoke(resultId: Long, result: Result): ServiceResult<Boolean> =
        resultRepository.updateResult(resultId, result)
}