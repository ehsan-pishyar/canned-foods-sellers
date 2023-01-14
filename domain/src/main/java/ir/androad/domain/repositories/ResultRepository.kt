package ir.androad.domain.repositories

import ir.androad.domain.models.Result
import ir.androad.domain.models.responses.ResultDetailsResponse
import ir.androad.domain.models.responses.ResultResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ResultRepository {

    suspend fun insertResult(result: Result): ServiceResult<Boolean>
    fun getResults(): Flow<ServiceResult<List<ResultResponse>>>
    suspend fun getResultDetails(resultId: Long): ServiceResult<ResultDetailsResponse>
    fun getResultsByTitle(resultTitle: String?): Flow<ServiceResult<List<ResultResponse>?>>
    suspend fun getResultsBySellerId(sellerId: Long): ServiceResult<List<ResultResponse>?>
    suspend fun getResultsBySellerCategoryId(sellerCategoryId: Int): ServiceResult<List<ResultResponse>?>
    suspend fun getResultsByResultCategoryId(resultCategoryId: Int): ServiceResult<List<ResultResponse>?>
    suspend fun getResultsByFoodCategoryId(foodCategoryId: Int): ServiceResult<List<ResultResponse>?>
    fun getResultsByVoteCount(voteCount: Long): Flow<ServiceResult<List<ResultResponse>?>>
    fun getResultsByRating(rating: Double): Flow<ServiceResult<List<ResultResponse>?>>
    suspend fun updateResult(resultId: Long, result: Result): ServiceResult<Boolean>
    suspend fun deleteResult(resultId: Long): ServiceResult<Boolean>
}