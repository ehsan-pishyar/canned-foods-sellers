package ir.androad.domain.repositories

import ir.androad.domain.models.responses.FoodCategoryResponse
import ir.androad.domain.models.responses.ResultsCategoryResponse
import ir.androad.domain.models.responses.SellerCategoryResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getSellerCategories(): Flow<ServiceResult<List<SellerCategoryResponse>?>>
    suspend fun getSellerCategoryById(sellerCategoryId: Int): ServiceResult<SellerCategoryResponse>

    fun getResultCategories(sellerCategoryId: Int): Flow<ServiceResult<List<ResultsCategoryResponse>?>>
    suspend fun getResultCategoryById(resultCategoryId: Int): ServiceResult<ResultsCategoryResponse>
    fun getResultCategoriesByTitle(resultCategoryTitle: String?): Flow<ServiceResult<List<ResultsCategoryResponse>?>>

    fun getFoodCategories(resultCategoryId: Int): Flow<ServiceResult<List<FoodCategoryResponse>?>>
    suspend fun getFoodCategoryById(foodCategoryId: Int): ServiceResult<FoodCategoryResponse>
    fun getFoodCategoriesByTitle(foodCategoryTitle: String?): Flow<ServiceResult<List<FoodCategoryResponse>?>>
}