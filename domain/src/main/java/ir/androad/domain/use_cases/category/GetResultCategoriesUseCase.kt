package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.ResultsCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetResultCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(sellerCategoryId: Int): Flow<ServiceResult<List<ResultsCategoryResponse>?>> =
        categoryRepository.getResultCategories(sellerCategoryId)
}