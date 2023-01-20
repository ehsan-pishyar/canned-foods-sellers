package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.FoodCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetFoodCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(resultCategoryId: Int): Flow<ServiceResult<List<FoodCategoryResponse>?>> =
        categoryRepository.getFoodCategories(resultCategoryId)
}