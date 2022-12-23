package ir.androad.repository.data_source

import ir.androad.cache.AppDatabase
import ir.androad.domain.models.User
import ir.androad.domain.models.responses.UserResponse
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
): UserRepository {
    
    override suspend fun insertUser(user: User): Flow<ServiceResult<UserResponse?>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(
        userId: Long,
        fetchFromRemote: Boolean
    ): Flow<ServiceResult<User?>> = flow {
        emit(ServiceResult.Loading())
    }

    override suspend fun updateUser(userId: Long, user: User): Flow<ServiceResult<User?>> {
        TODO("Not yet implemented")
    }

}