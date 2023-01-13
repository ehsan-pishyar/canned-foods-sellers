package ir.androad.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ir.androad.cache.AppDatabase
import ir.androad.cache.daos.UserDao
import ir.androad.domain.data_store.UserDataStore
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.use_cases.user.*
import ir.androad.network.ApiService
import ir.androad.repository.data_source.UserRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object UserRepositoryModule {

    @Provides
    fun providesUserRepositoryImpl(
        apiService: ApiService,
        userDao: UserDao,
        userDataStore: UserDataStore
    ): UserRepositoryImpl = UserRepositoryImpl(apiService, userDao, userDataStore)

    @Provides
    fun providesUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository = userRepositoryImpl

    @Provides
    fun providesGetUserByIdUseCase(
        userRepository: UserRepository
    ): GetUserByIdUseCase = GetUserByIdUseCase(userRepository)

    @Provides
    fun providesGetUsersByEmailUseCase(
        userRepository: UserRepository
    ): GetUsersByEmailUseCase = GetUsersByEmailUseCase(userRepository)

    @Provides
    fun providesGetUserByEmailAndPasswordUseCase(
        userRepository: UserRepository
    ): GetUserByEmailAndPasswordUseCase = GetUserByEmailAndPasswordUseCase(userRepository)

    @Provides
    fun providesInsertUserUseCase(
        userRepository: UserRepository
    ): InsertUserUseCase = InsertUserUseCase(userRepository)

    @Provides
    fun providesUpdateUserUseCase(
        userRepository: UserRepository
    ): UpdateUserUseCase = UpdateUserUseCase(userRepository)

}
