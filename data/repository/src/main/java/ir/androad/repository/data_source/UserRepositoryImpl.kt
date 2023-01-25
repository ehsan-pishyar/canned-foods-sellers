package ir.androad.repository.data_source

import ir.androad.cache.daos.UserDao
import ir.androad.domain.data_store.UserDataStore
import ir.androad.domain.models.User
import ir.androad.domain.models.responses.UserResponse
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.models.responses.UserResponseDto
import ir.androad.network.services.UserApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toDto
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService,
    private val userDao: UserDao,
    private val userDataStore: UserDataStore
): UserRepository {

    override suspend fun insertUser(user: User): ServiceResult<Boolean> {
        val userEntity = user.toEntity()
        val userDto = userEntity.toDto()

        val remoteUser = try {
            userApiService.insertUser(userDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        }

        remoteUser.let {
            userDao.insertUser(it.toEntity())
            userDataStore.saveUserState(email = it.user?.email!!, password = it.user?.password!!)
        }
        return ServiceResult.Success(true)
    }

    override suspend fun getUserById(
        userId: Long
    ): ServiceResult<UserResponse> {
        val userEntity = userDao.fetchUserById(userId)

        if (userDao.isUserCacheAvailable() == 0) {
            val userDto = try {
                userApiService.getUserById(userId)
            } catch (e: IOException) {
                e.printStackTrace()
                return ServiceResult.Error(message = e.message)
            } catch (e: Exception) {
                e.printStackTrace()
                return ServiceResult.Error(message = e.message)
            }
            userDao.insertUser(userDto.toEntity())
        }
        return ServiceResult.Success(data = userEntity.toDomain())
    }

    override fun getUsersByEmail(email: String?): Flow<ServiceResult<List<UserResponse>>> = flow {
        emit(ServiceResult.Loading(isLoading = true))

        val usersRemote = try {
            userApiService.getUsersByEmail(email!!)
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(message = e.message))
            null
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(message = e.message))
            null
        } as UserResponseDto

        usersRemote.let {
            emit(ServiceResult.Success(data = listOf(it.toEntity().toDomain())))
        }
        emit(ServiceResult.Loading(isLoading = false))
    }


    override suspend fun getUserByEmailAndPassword(
        email: String?,
        password: String?
    ): ServiceResult<Boolean> {
        val remoteUser = try {
            userApiService.getUserByEmailAndPassword(email, password)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = false, message = e.message)
        }

        remoteUser.let {
            return ServiceResult.Success(data = true)
        }
    }

    override suspend fun updateUser(user: User): ServiceResult<Boolean> {
        val userEntity = user.toEntity()
        val userDto = userEntity.toDto()

        val userRemote = try {
            userApiService.updateUser(user.id, userDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        }

        userRemote.let {
            userDao.updateUser(it.toEntity())
            userDataStore.saveUserState(email = it.user?.email!!, password = it.user?.password!!)
        }
        return ServiceResult.Success(data = true)
    }
}