package ir.androad.repository.data_source

import ir.androad.cache.AppDatabase
import ir.androad.domain.models.Seller
import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.models.responses.SellerResponse
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.models.responses.SellerResponseDto
import ir.androad.network.services.SellerApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toDto
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class SellerRepositoryImpl @Inject constructor(
    private val sellerApiService: SellerApiService,
    appDatabase: AppDatabase
): SellerRepository {

    private val sellerDao = appDatabase.sellerDao()

    override suspend fun insertSeller(seller: Seller): ServiceResult<Boolean> {
        val sellerEntity = seller.toEntity()
        val sellerDto = sellerEntity.toDto()

        val remoteSeller = try {
            sellerApiService.insertSeller(sellerDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        }

        remoteSeller.let { sellerResponseDto ->
            sellerDao.insertSeller(sellerResponseDto.toEntity())
            return ServiceResult.Success(data = true)
        }
    }

    override fun getSellers(): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val sellers = sellerDao.fetchSellers()?.map {
            it.toDomain()
        }
        emit(ServiceResult.Success(sellers))

        val remoteSellers = try {
            sellerApiService.getSellers()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let { sellerResponseDto ->
            sellerDao.deleteSellers()
            sellerDao.insertSeller(sellerResponseDto.toEntity())
            emit(ServiceResult.Success(data = sellerDao.fetchSellers()?.map { it.toDomain() }))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getSellerDetails(id: Long): ServiceResult<SellerDetailsResponse> {
        val remoteSeller = try {
            sellerApiService.getSellerDetails(id)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteSeller.let {
            return ServiceResult.Success(remoteSeller.toEntity().toDomain())
        }
    }

    override fun getSellersByTitle(title: String?): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByTitle(title)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersByDescription(description: String?): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByDescription(description)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersByLocationTitle(locationTitle: String?): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByLocationTitle(locationTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersByResultTitle(resultTitle: String?): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByResultTitle(resultTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersBySellerCategoryId(sellerCategoryId: Int): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersBySellerCategoryId(sellerCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersByResultCategoryId(resultCategoryId: Int): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByResultCategoryId(resultCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getSellersByFoodCategoryId(foodCategoryId: Int): Flow<ServiceResult<List<SellerResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellers = try {
            sellerApiService.getSellersByFoodCategoryId(foodCategoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerResponseDto

        remoteSellers.let {
            emit(ServiceResult.Success(listOf(it.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun updateSeller(sellerId: Long, seller: Seller): ServiceResult<Boolean> {
        val sellerEntity = seller.toEntity()
        val sellerDto = sellerEntity.toDto()

        val remoteSeller = try {
            sellerApiService.updateSeller(sellerId = sellerId, sellerDto = sellerDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteSeller.let {
            sellerDao.deleteSellers()
            sellerDao.insertSeller(it.toEntity())
            return ServiceResult.Success(data = true)
        }
    }
}