package ir.androad.domain.repositories

import ir.androad.domain.models.Seller
import ir.androad.domain.models.responses.SellerResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface SellerRepository {

    suspend fun insertSeller(seller: Seller): ServiceResult<SellerResponse>
    fun getSellers(): Flow<ServiceResult<List<SellerResponse>>>
    suspend fun getSellerById(id: Long): ServiceResult<SellerResponse>
    fun getSellersByTitle(title: String?): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersByDescription(description: String?): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersByLocationTitle(locationTitle: String?): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersByResultTitle(resultTitle: String?): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersBySellerCategoryId(sellerCategoryId: Int): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersByResultCategoryId(resultCategoryId: Int): Flow<ServiceResult<List<SellerResponse>>>
    fun getSellersByFoodCategoryId(foodCategoryId: Int): Flow<ServiceResult<List<SellerResponse>>>
    suspend fun updateSeller(seller: Seller): ServiceResult<Boolean>

}