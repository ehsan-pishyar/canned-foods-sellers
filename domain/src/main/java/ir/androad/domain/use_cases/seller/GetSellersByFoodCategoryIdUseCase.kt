package ir.androad.domain.use_cases.seller

import ir.androad.domain.models.responses.SellerResponse
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetSellersByFoodCategoryIdUseCase(
    private val sellerRepository: SellerRepository
) {

    operator fun invoke(foodCategoryId: Int): Flow<ServiceResult<List<SellerResponse>?>> =
        sellerRepository.getSellersByFoodCategoryId(foodCategoryId)
}