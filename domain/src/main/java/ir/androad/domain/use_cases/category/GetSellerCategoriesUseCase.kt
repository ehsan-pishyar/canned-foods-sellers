package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.SellerCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetSellerCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<SellerCategoryResponse>?>> =
        categoryRepository.getSellerCategories()
}