package ir.androad.repository.data_source

import ir.androad.domain.models.responses.ResultRatingsResponse
import ir.androad.domain.models.responses.SellerRatingsResponse
import ir.androad.domain.repositories.RatingsRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.models.responses.ResultRatingsResponseDto
import ir.androad.network.models.responses.SellerRatingsResponseDto
import ir.androad.network.services.ResultApiService
import ir.androad.network.services.SellerApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class RatingsRepositoryImpl @Inject constructor (
    private val sellerApiService: SellerApiService,
    private val resultApiService: ResultApiService
): RatingsRepository {

    override fun getSellerRatings(sellerId: Long): Flow<ServiceResult<List<SellerRatingsResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteRatings = try {
            sellerApiService.getSellerRatings(sellerId = sellerId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerRatingsResponseDto

        remoteRatings.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }

    override fun getResultRatings(resultId: Long): Flow<ServiceResult<List<ResultRatingsResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteRatings = try {
            resultApiService.getResultRatings(resultId = resultId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultRatingsResponseDto

        remoteRatings.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
    }
}