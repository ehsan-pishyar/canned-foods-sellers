package ir.androad.domain.repositories

import ir.androad.domain.models.FoodCategory
import ir.androad.domain.models.ResultCategory
import ir.androad.domain.models.SellerCategory
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getSellerCategories(): Flow<ServiceResult<List<SellerCategory>?>>
    suspend fun getSellerCategoryById(sellerCategoryId: Int): Flow<ServiceResult<SellerCategory>>

    suspend fun getResultCategories(): Flow<ServiceResult<List<ResultCategory>?>>
    suspend fun getResultCategoryById(resultCategoryId: Int): Flow<ServiceResult<ResultCategory>>
    suspend fun getResultCategoriesByTitle(resultCategoryTitle: String?): Flow<ServiceResult<List<ResultCategory>?>>
    suspend fun getResultCategoriesBySellerCategoryId(
        sellerCategoryId: Int
    ): Flow<ServiceResult<List<ResultCategory>?>>

    suspend fun getFoodCategories(): Flow<ServiceResult<List<FoodCategory>?>>
    suspend fun getFoodCategoryById(foodCategoryId: Int): Flow<ServiceResult<FoodCategory>>
    suspend fun getFoodCategoriesByTitle(foodCategoryTitle: String?): Flow<ServiceResult<List<FoodCategory>?>>
    suspend fun getFoodCategoriesByResultCategoryId(
        resultCategoryId: Int
    ): Flow<ServiceResult<List<FoodCategory>?>>
}