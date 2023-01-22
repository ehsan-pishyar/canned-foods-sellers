package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.daos.SellerDao
import ir.androad.domain.data_store.SellerDataStore
import ir.androad.domain.repositories.SellerRepository
import ir.androad.domain.use_cases.seller.GetSellerDetailsUseCase
import ir.androad.domain.use_cases.seller.GetSellersUseCase
import ir.androad.network.services.SellerApiService
import ir.androad.repository.data_source.SellerRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object SellerRepositoryModule {

    @Provides
    fun providesSellerRepositoryImpl(
        sellerApiService: SellerApiService,
        sellerDao: SellerDao,
        sellerDataStore: SellerDataStore
    ): SellerRepositoryImpl =
        SellerRepositoryImpl(
            sellerApiService = sellerApiService,
            sellerDao = sellerDao,
            sellerDataStore = sellerDataStore
        )

    @Provides
    fun providesSellerRepository(
        sellerRepositoryImpl: SellerRepositoryImpl
    ): SellerRepository = sellerRepositoryImpl

    @Provides
    fun providesGetSellersUseCase(
        sellerRepository: SellerRepository
    ): GetSellersUseCase = GetSellersUseCase(sellerRepository)

    @Provides
    fun providesGetSellerDetailsUseCase(
        sellerRepository: SellerRepository
    ): GetSellerDetailsUseCase = GetSellerDetailsUseCase(sellerRepository)
}