package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.domain.repositories.RatingsRepository
import ir.androad.network.services.ResultApiService
import ir.androad.network.services.SellerApiService
import ir.androad.repository.data_source.RatingsRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RatingsRepositoryModule {

    @Provides
    fun providesRatingsRepositoryImpl(
        sellerApiService: SellerApiService,
        resultApiService: ResultApiService
    ): RatingsRepositoryImpl =
        RatingsRepositoryImpl(
            sellerApiService = sellerApiService,
            resultApiService = resultApiService
        )

    @Provides
    fun providesRatingsRepository(
        ratingsRepositoryImpl: RatingsRepositoryImpl
    ): RatingsRepository = ratingsRepositoryImpl
}