package ir.androad.repository.data_source

import ir.androad.cache.daos.ResultDao
import ir.androad.domain.models.Result
import ir.androad.domain.models.responses.ResultDetailsResponse
import ir.androad.domain.models.responses.ResultResponse
import ir.androad.domain.repositories.ResultRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.ApiService
import ir.androad.network.models.responses.ResultResponseDto
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toDto
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val resultDao: ResultDao
): ResultRepository {

    override suspend fun insertResult(result: Result): ServiceResult<Boolean> {
        val resultEntity = result.toEntity()
        val resultDto = resultEntity.toDto()

        val remoteResult = try {
            apiService.insertResult(resultDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        }

        remoteResult.let {
            resultDao.insertResult(it.toEntity())
            return ServiceResult.Success(data = true)
        }
    }

    override fun getResults(): Flow<ServiceResult<List<ResultResponse>>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        resultDao.fetchResults()?.map {
            it.toDomain()
        }

        val remoteResults = try {
            apiService.getResults()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultResponseDto

        remoteResults.let { resultsDto ->
            resultDao.insertResult(resultsDto.toEntity())
            emit(ServiceResult.Success(resultDao.fetchResults()?.map { it.toDomain() }))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getResultDetails(resultId: Long): ServiceResult<ResultDetailsResponse> {
        val resultEntity = resultDao.fetchResultDetails(resultId)

        if (resultDao.isResultCacheAvailable() != 0) {
            return ServiceResult.Success(data = resultEntity.toDomain())
        }

        val remoteResultDetails = try {
            apiService.getResultDetails(resultId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, message = e.message)
        }

        remoteResultDetails.let {
            resultDao.insertResultDetails(it.toEntity())
            return ServiceResult.Success(resultDao.fetchResultDetails(resultId).toDomain())
        }
    }

    override fun getResultsByTitle(resultTitle: String?): Flow<ServiceResult<List<ResultResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val resultsEntity = resultDao.fetchResultsByTitle(resultTitle)
        if (resultsEntity?.isNotEmpty() == true) {
            emit(ServiceResult.Success(resultsEntity.map { it.toDomain() }))
        }

        val remoteResult = try {
            apiService.getResultsByTitle(resultTitle)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultResponseDto

        remoteResult.let { resultResponseDto ->
            resultDao.insertResult(resultResponseDto.toEntity())
            emit(ServiceResult.Success(resultDao.fetchResultsByTitle(resultTitle)?.map { it.toDomain() }))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getResultsBySellerId(sellerId: Long): ServiceResult<List<ResultResponse>?> {
        return try {
            val remoteResults = apiService.getResultsBySellerId(sellerId)
            ServiceResult.Success(data = listOf(remoteResults.toEntity().toDomain()))
        } catch (e: IOException) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        }
    }

    override suspend fun getResultsBySellerCategoryId(sellerCategoryId: Int): ServiceResult<List<ResultResponse>?> {
        return try {
            val remoteResults = apiService.getResultsBySellerCategoryId(sellerCategoryId)
            ServiceResult.Success(data = listOf(remoteResults.toEntity().toDomain()))
        } catch (e: IOException) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        }
    }

    override suspend fun getResultsByResultCategoryId(resultCategoryId: Int): ServiceResult<List<ResultResponse>?> {
        return try {
            val remoteResults = apiService.getResultsByResultCategoryId(resultCategoryId)
            ServiceResult.Success(data = listOf(remoteResults.toEntity().toDomain()))
        } catch (e: IOException) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        }
    }

    override suspend fun getResultsByFoodCategoryId(foodCategoryId: Int): ServiceResult<List<ResultResponse>?> {
        return try {
            val remoteResults = apiService.getResultsByFoodCategoryId(foodCategoryId)
            ServiceResult.Success(data = listOf(remoteResults.toEntity().toDomain()))
        } catch (e: IOException) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            ServiceResult.Error(data = null, message = e.message)
        }
    }

    override fun getResultsByVoteCount(voteCount: Long): Flow<ServiceResult<List<ResultResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteResults = try {
            apiService.getResultsByVoteCount(voteCount)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultResponseDto

        remoteResults.let {
            emit(ServiceResult.Success(listOf(remoteResults.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getResultsByRating(rating: Double): Flow<ServiceResult<List<ResultResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteResults = try {
            apiService.getResultsByRating(rating)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultResponseDto

        remoteResults.let {
            emit(ServiceResult.Success(listOf(remoteResults.toEntity().toDomain())))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun updateResult(resultId: Long, result: Result): ServiceResult<Boolean> {
        val resultEntity = result.toEntity()
        val resultDto = resultEntity.toDto()

        val remoteResult = try {
            apiService.updateResult(resultId = resultDto.id!!, result = resultDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        }

        remoteResult.let {
            resultDao.updateResult(it.toEntity())
            return ServiceResult.Success(data = true)
        }
    }

    override suspend fun deleteResult(resultId: Long): ServiceResult<Boolean> {
        resultDao.deleteResultById(resultId)
        val result = resultDao.fetchResultById(resultId)
        return if (result.title?.trim()?.length == 0) {
            ServiceResult.Success(data = true)
        } else {
            ServiceResult.Error(data = false)
        }
    }
}