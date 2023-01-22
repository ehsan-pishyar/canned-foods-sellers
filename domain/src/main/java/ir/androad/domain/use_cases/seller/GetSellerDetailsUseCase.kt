package ir.androad.domain.use_cases.seller

import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetSellerDetailsUseCase(
    private val sellerRepository: SellerRepository
) {

    operator fun invoke(sellerId: Long): Flow<ServiceResult<SellerDetailsResponse>> =
        sellerRepository.getSellerDetails(sellerId)
}