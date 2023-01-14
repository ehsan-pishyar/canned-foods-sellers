package ir.androad.repository.data_source

import ir.androad.domain.models.responses.FoodCategoryResponse
import ir.androad.domain.models.responses.ResultsCategoryResponse
import ir.androad.domain.models.responses.SellerCategoryResponse
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.ApiService
import ir.androad.network.models.responses.FoodCategoryResponseDto
import ir.androad.network.models.responses.ResultsCategoryResponseDto
import ir.androad.network.models.responses.SellerCategoryResponseDto
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CategoryRepository {

    override fun getSellerCategories(): Flow<ServiceResult<List<SellerCategoryResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellerCategories = try {
            apiService.getSellerCategories()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerCategoryResponseDto

        remoteSellerCategories.let {
            emit((ServiceResult.Success(data = listOf(it.toEntity().toDomain()))))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getSellerCategoryById(sellerCategoryId: Int): ServiceResult<SellerCategoryResponse> {
        val remoteSellerCategory = try {
            apiService.getSellerCategoryById(sellerCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteSellerCategory.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getResultCategories(sellerCategoryId: Int): Flow<ServiceResult<List<ResultsCategoryResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteResultCategories = try {
            apiService.getResultCategories(sellerCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultsCategoryResponseDto

        remoteResultCategories.let {
            emit((ServiceResult.Success(data = listOf(it.toEntity().toDomain()))))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getResultCategoryById(resultCategoryId: Int): ServiceResult<ResultsCategoryResponse> {
        val remoteResultCategory = try {
            apiService.getResultCategoryById(resultCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteResultCategory.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getResultCategoriesByTitle(resultCategoryTitle: String?): Flow<ServiceResult<List<ResultsCategoryResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteResultCategories = try {
            apiService.getResultCategoriesByTitle(resultCategoryTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultsCategoryResponseDto

        remoteResultCategories.let {
            emit((ServiceResult.Success(data = listOf(it.toEntity().toDomain()))))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getFoodCategories(resultCategoryId: Int): Flow<ServiceResult<List<FoodCategoryResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteFoodCategories = try {
            apiService.getFoodCategories(resultCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as FoodCategoryResponseDto

        remoteFoodCategories.let {
            emit((ServiceResult.Success(data = listOf(it.toEntity().toDomain()))))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getFoodCategoryById(foodCategoryId: Int): ServiceResult<FoodCategoryResponse> {
        val remoteResultCategory = try {
            apiService.getFoodCategoryById(foodCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteResultCategory.let {
            return ServiceResult.Success(data = it.toEntity().toDomain())
        }
    }

    override fun getFoodCategoriesByTitle(foodCategoryTitle: String?): Flow<ServiceResult<List<FoodCategoryResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteFoodCategories = try {
            apiService.getFoodCategoriesByTitle(foodCategoryTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as FoodCategoryResponseDto

        remoteFoodCategories.let {
            emit((ServiceResult.Success(data = listOf(it.toEntity().toDomain()))))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }
}