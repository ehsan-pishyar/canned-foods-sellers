package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.daos.LocationDao
import ir.androad.domain.repositories.LocationRepository
import ir.androad.network.services.LocationApiService
import ir.androad.repository.data_source.LocationRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object LocationRepositoryModule {

    @Provides
    fun providesLocationRepositoryImpl(
        locationApiService: LocationApiService,
        locationDao: LocationDao
    ): LocationRepositoryImpl = LocationRepositoryImpl(
        locationApiService = locationApiService,
        locationDao = locationDao
    )

    @Provides
    fun providesLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository = locationRepositoryImpl
}