package ir.androad.domain.use_cases.seller

import ir.androad.domain.models.responses.SellerResponse
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult

class GetSellerByIdUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend operator fun invoke(sellerId: Long): ServiceResult<SellerResponse> =
        sellerRepository.getSellerById(sellerId)
}