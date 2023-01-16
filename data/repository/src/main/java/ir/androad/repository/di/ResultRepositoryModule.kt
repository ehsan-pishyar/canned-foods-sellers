package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.daos.ResultDao
import ir.androad.domain.repositories.ResultRepository
import ir.androad.network.services.ResultApiService
import ir.androad.repository.data_source.ResultRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object ResultRepositoryModule {

    @Provides
    fun providesResultRepositoryImpl(
        resultApiService: ResultApiService,
        resultDao: ResultDao
    ): ResultRepositoryImpl = ResultRepositoryImpl(resultApiService = resultApiService, resultDao = resultDao)

    @Provides
    fun providesResultRepository(
        resultRepositoryImpl: ResultRepositoryImpl
    ): ResultRepository = resultRepositoryImpl
}