package ir.androad.domain.use_cases.seller

import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult

class GetSellerDetailsUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend operator fun invoke(sellerId: Long): ServiceResult<SellerDetailsResponse> =
        sellerRepository.getSellerDetails(sellerId)
}