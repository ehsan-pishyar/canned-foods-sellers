package ir.androad.domain.use_cases.result

import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.domain.models.Result

class InsertResultUseCase(
    private val resultRepository: ResultRepository
) {

    suspend operator fun invoke(result: Result): ServiceResult<Boolean> =
        resultRepository.insertResult(result)
}