package ir.androad.domain.use_cases.result

import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult

class DeleteResultUseCase(
    private val resultRepository: ResultRepository
) {

    suspend operator fun invoke(resultId: Long): ServiceResult<Boolean> =
        resultRepository.deleteResult(resultId)
}