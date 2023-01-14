package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.daos.ResultDao
import ir.androad.domain.repositories.ResultRepository
import ir.androad.network.ApiService
import ir.androad.repository.data_source.ResultRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object ResultRepositoryModule {

    @Provides
    fun providesResultRepositoryImpl(
        apiService: ApiService,
        resultDao: ResultDao
    ): ResultRepositoryImpl = ResultRepositoryImpl(apiService, resultDao)

    @Provides
    fun providesResultRepository(
        resultRepositoryImpl: ResultRepositoryImpl
    ): ResultRepository = resultRepositoryImpl
}