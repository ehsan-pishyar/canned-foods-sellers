package ir.androad.domain.repositories

import ir.androad.domain.models.SellerCategory
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow


interface SellerCategoryRepository {

    suspend fun insertSellerCategory(sellerCategory: SellerCategory): Flow<ServiceResult<SellerCategory?>>
    suspend fun getSellerCategories(): Flow<ServiceResult<List<SellerCategory>?>>
    suspend fun getSellerCategoryById(sellerCategoryId: Int): Flow<ServiceResult<SellerCategory>>
    suspend fun updateSellerCategory(sellerCategoryId: Int, sellerCategory: SellerCategory): Flow<ServiceResult<SellerCategory?>>
}