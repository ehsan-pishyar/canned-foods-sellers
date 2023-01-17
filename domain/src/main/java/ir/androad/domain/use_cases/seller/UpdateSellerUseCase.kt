package ir.androad.domain.use_cases.seller

import ir.androad.domain.models.Seller
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult

class UpdateSellerUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend operator fun invoke(sellerId: Long, seller: Seller): ServiceResult<Boolean> =
        sellerRepository.updateSeller(sellerId, seller)
}