package ir.androad.repository.data_source

import ir.androad.domain.models.FoodCategory
import ir.androad.domain.models.ResultCategory
import ir.androad.domain.models.SellerCategory
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl: CategoryRepository {

    override suspend fun getSellerCategories(): Flow<ServiceResult<List<SellerCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSellerCategoryById(sellerCategoryId: Int): Flow<ServiceResult<SellerCategory>> {
        TODO("Not yet implemented")
    }

    override suspend fun getResultCategories(): Flow<ServiceResult<List<ResultCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getResultCategoryById(resultCategoryId: Int): Flow<ServiceResult<ResultCategory>> {
        TODO("Not yet implemented")
    }

    override suspend fun getResultCategoriesByTitle(resultCategoryTitle: String?): Flow<ServiceResult<List<ResultCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getResultCategoriesBySellerCategoryId(sellerCategoryId: Int): Flow<ServiceResult<List<ResultCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodCategories(): Flow<ServiceResult<List<FoodCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodCategoryById(foodCategoryId: Int): Flow<ServiceResult<FoodCategory>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodCategoriesByTitle(foodCategoryTitle: String?): Flow<ServiceResult<List<FoodCategory>?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodCategoriesByResultCategoryId(resultCategoryId: Int): Flow<ServiceResult<List<FoodCategory>?>> {
        TODO("Not yet implemented")
    }
}