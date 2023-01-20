package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.FoodCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetFoodCategoriesByTitleUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(resultCategoryTitle: String?): Flow<ServiceResult<List<FoodCategoryResponse>?>> =
        categoryRepository.getFoodCategoriesByTitle(resultCategoryTitle)
}