package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.AppDatabase
import ir.androad.domain.repositories.SellerRepository
import ir.androad.network.services.SellerApiService
import ir.androad.repository.data_source.SellerRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object SellerRepositoryModule {

    @Provides
    fun providesSellerRepositoryImpl(
        sellerApiService: SellerApiService,
        appDatabase: AppDatabase
    ): SellerRepositoryImpl = SellerRepositoryImpl(sellerApiService = sellerApiService, appDatabase = appDatabase)

    @Provides
    fun providesSellerRepository(
        sellerRepositoryImpl: SellerRepositoryImpl
    ): SellerRepository = sellerRepositoryImpl
}