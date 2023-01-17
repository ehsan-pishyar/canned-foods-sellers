package ir.androad.domain.repositories

import ir.androad.domain.models.responses.ResultRatingsResponse
import ir.androad.domain.models.responses.SellerRatingsResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface RatingsRepository {

    fun getSellerRatings(sellerId: Long): Flow<ServiceResult<List<SellerRatingsResponse>?>>
    fun getResultRatings(resultId: Long): Flow<ServiceResult<List<ResultRatingsResponse>?>>
}