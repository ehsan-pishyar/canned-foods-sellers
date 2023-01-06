package ir.androad.domain.repositories

import ir.androad.domain.models.User
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: User): ServiceResult<Boolean>
    suspend fun getUserById(userId: Long): ServiceResult<User>
    fun getUsersByEmail(email: String): Flow<ServiceResult<List<User>>>
    suspend fun updateUser(user: User): ServiceResult<Boolean>
}