package ir.androad.domain.use_cases.category

import ir.androad.domain.models.responses.FoodCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult

class GetFoodCategoryByIdUseCase(
    private val categoryRepository: CategoryRepository
) {

    suspend operator fun invoke(foodCategoryId: Int): ServiceResult<FoodCategoryResponse> =
        categoryRepository.getFoodCategoryById(foodCategoryId)
}