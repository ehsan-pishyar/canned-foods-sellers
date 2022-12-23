package ir.androad.domain.repositories

import ir.androad.domain.models.User
import ir.androad.domain.models.responses.UserResponse
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: User): Flow<ServiceResult<UserResponse?>>
    suspend fun getUserById(userId: Long, fetchFromRemote: Boolean): Flow<ServiceResult<User?>>
    suspend fun updateUser(userId: Long, user: User): Flow<ServiceResult<User?>>
}