package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.SellerCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult

class GetResultCategoryByIdUseCase(
    private val categoryRepository: CategoryRepository
) {

    suspend operator fun invoke(sellerCategoryId: Int): ServiceResult<SellerCategoryResponse> =
        categoryRepository.getSellerCategoryById(sellerCategoryId)
}