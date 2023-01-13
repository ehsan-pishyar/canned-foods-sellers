package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.AppDatabase
import ir.androad.domain.repositories.SellerRepository
import ir.androad.network.ApiService
import ir.androad.repository.data_source.SellerRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object SellerRepositoryModule {

    @Provides
    fun providesSellerRepositoryImpl(
        apiService: ApiService,
        appDatabase: AppDatabase
    ): SellerRepositoryImpl = SellerRepositoryImpl(apiService, appDatabase)

    @Provides
    fun providesSellerRepository(
        sellerRepositoryImpl: SellerRepositoryImpl
    ): SellerRepository = sellerRepositoryImpl
}