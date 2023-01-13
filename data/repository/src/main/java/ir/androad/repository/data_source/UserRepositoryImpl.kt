package ir.androad.repository.data_source

import ir.androad.cache.daos.UserDao
import ir.androad.domain.data_store.UserDataStore
import ir.androad.domain.models.User
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult
import ir.androad.network.ApiService
import ir.androad.repository.mappers.toDomain
import ir.androad.repository.mappers.toDto
import ir.androad.repository.mappers.toEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
    private val userDataStore: UserDataStore
): UserRepository {

    override suspend fun insertUser(user: User): ServiceResult<Boolean> {
        val userEntity = user.toEntity()
        val userDto = userEntity.toDto()

        val remoteUser = try {
            apiService.insertUser(userDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        }

        remoteUser?.let {
            userDao.insertUser(it.toEntity())
            userDataStore.saveUserState(email = it.email!!, password = it.password!!)
        }
        return ServiceResult.Success(true)
    }

    override suspend fun getUserById(
        userId: Long
    ): ServiceResult<User> {
        val userEntity = userDao.fetchUserById(userId)

        if (userDao.isUserCacheAvailable() == 0) {
            val userDto = try {
                apiService.getUserById(userId)
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

    override fun getUsersByEmail(email: String): Flow<ServiceResult<List<User>>> = flow {
        emit(ServiceResult.Loading(true))

        val usersRemote = try {
            apiService.getUsersByEmail(email).map { it.toEntity().toDomain() }
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(message = e.message))
            null
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(message = e.message))
            null
        }

        usersRemote?.let {
            emit(ServiceResult.Success(data = it))
        }
    }.flowOn(IO)

    override suspend fun getUserByEmailAndPassword(
        email: String?,
        password: String?
    ): ServiceResult<Boolean> {
        val remoteUser = try {
            apiService.getUserByEmailAndPassword(email, password)
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
            apiService.updateUser(user.id, userDto)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(message = e.message)
        }

        userRemote?.let {
            userDao.updateUser(it.toEntity())
            userDataStore.saveUserState(email = it.email!!, password = it.password!!)
        }
        return ServiceResult.Success(data = true)
    }
}