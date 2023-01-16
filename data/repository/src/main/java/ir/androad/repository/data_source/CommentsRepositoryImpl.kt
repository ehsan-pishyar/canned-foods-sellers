package ir.androad.repository.data_source

import ir.androad.cache.daos.CommentDao
import ir.androad.domain.models.responses.ResultCommentResponse
import ir.androad.domain.models.responses.SellerCommentResponse
import ir.androad.domain.repositories.CommentsRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.models.responses.ResultCommentResponseDto
import ir.androad.network.models.responses.SellerCommentResponseDto
import ir.androad.network.services.ResultApiService
import ir.androad.network.services.SellerApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(
    private val sellerApiService: SellerApiService,
    private val resultApiService: ResultApiService,
    private val commentsDao: CommentDao
): CommentsRepository {

    override fun getSellerComments(sellerId: Long): Flow<ServiceResult<List<SellerCommentResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteSellerComments = try {
            sellerApiService.getSellerComments(sellerId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as SellerCommentResponseDto

        remoteSellerComments.let { sellerCommentsResponseDto ->
            commentsDao.insertSellerComment(sellerCommentsResponseDto.toEntity())
            emit(ServiceResult.Success(data = commentsDao.fetchSellerComments()?.map { it.toDomain() }))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getResultComments(resultId: Long): Flow<ServiceResult<List<ResultCommentResponse>?>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val remoteResultComments = try {
            resultApiService.getResultComments(resultId)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, message = e.message))
        } as ResultCommentResponseDto

        remoteResultComments.let { resultCommentsResponseDto ->
            commentsDao.insertResultComments(resultCommentsResponseDto.toEntity())
            emit(ServiceResult.Success(data = commentsDao.fetchResultComments(resultId)?.map { it.toDomain() }))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }
}