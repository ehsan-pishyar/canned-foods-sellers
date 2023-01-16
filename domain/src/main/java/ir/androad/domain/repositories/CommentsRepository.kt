package ir.androad.domain.repositories

import ir.androad.domain.models.responses.ResultCommentResponse
import ir.androad.domain.models.responses.SellerCommentResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface CommentsRepository {

    fun getSellerComments(sellerId: Long): Flow<ServiceResult<List<SellerCommentResponse>?>>

    fun getResultComments(resultId: Long): Flow<ServiceResult<List<ResultCommentResponse>?>>
}