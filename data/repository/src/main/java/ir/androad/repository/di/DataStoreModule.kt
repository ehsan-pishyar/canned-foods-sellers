package ir.androad.repository.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.androad.domain.data_store.OnBoardingDataStore
import ir.androad.domain.data_store.SellerDataStore
import ir.androad.domain.data_store.UserDataStore
import ir.androad.repository.data_store.OnBoardingDataStoreDataSource
import ir.androad.repository.data_store.SellerDataStoreDataSource
import ir.androad.repository.data_store.UserDataStoreDataSource

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataStoreModule {

    // OnBoarding DataStore
    @Provides
    fun provideOnBoardingDataStoreDataSource(
        @ApplicationContext context: Context
    ): OnBoardingDataStoreDataSource = OnBoardingDataStoreDataSource(context)

    @Provides
    fun providesOnBoardingDataStore(
        onBoardingDataStoreDataSource: OnBoardingDataStoreDataSource
    ): OnBoardingDataStore = onBoardingDataStoreDataSource

    // User DataStore
    @Provides
    fun providersUserDataStoreDataSource(
        @ApplicationContext context: Context
    ): UserDataStoreDataSource = UserDataStoreDataSource(context)

    @Provides
    fun providesUserDataStore(
        userDataStoreDataSource: UserDataStoreDataSource
    ): UserDataStore = userDataStoreDataSource

    // Seller DataStore
    @Provides
    fun providesSellerDataStoreDataSource(
        @ApplicationContext context: Context
    ): SellerDataStoreDataSource = SellerDataStoreDataSource(context)

    @Provides
    fun providesSellerDataStore(
        sellerDataStoreDataSource: SellerDataStoreDataSource
    ): SellerDataStore = sellerDataStoreDataSource
}