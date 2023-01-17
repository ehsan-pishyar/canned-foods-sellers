package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.domain.repositories.CategoryRepository
import ir.androad.network.services.CategoryApiService
import ir.androad.repository.data_source.CategoryRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object CategoryRepositoryModule {

    @Provides
    fun providesCategoryRepositoryImpl(
        categoryApiService: CategoryApiService
    ): CategoryRepositoryImpl = CategoryRepositoryImpl(categoryApiService)

    @Provides
    fun providesCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository = categoryRepositoryImpl
}