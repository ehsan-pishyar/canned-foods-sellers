package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.daos.CommentDao
import ir.androad.network.services.ResultApiService
import ir.androad.network.services.SellerApiService
import ir.androad.repository.data_source.CommentsRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object CommentsRepositoryImpl {

    @Provides
    fun providesCommentsRepositoryImpl(
        sellerApiService: SellerApiService,
        resultApiService: ResultApiService,
        commentDao: CommentDao
    ): CommentsRepositoryImpl =
        CommentsRepositoryImpl(
            sellerApiService = sellerApiService,
            resultApiService = resultApiService,
            commentsDao = commentDao
        )
}