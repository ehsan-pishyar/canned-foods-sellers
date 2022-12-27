package ir.androad.repository.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.androad.domain.repositories.OnBoardingDataStore
import ir.androad.repository.data_store.OnBoardingDataStoreDataSource

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataStoreModule {

    @Provides
    fun provideOnBoardingDataStoreDataSource(
        @ApplicationContext context: Context
    ): OnBoardingDataStoreDataSource = OnBoardingDataStoreDataSource(context)

    @Provides
    fun providesOnBoardingRepository(
        onBoardingDataStoreDataSource: OnBoardingDataStoreDataSource
    ): OnBoardingDataStore = onBoardingDataStoreDataSource
}