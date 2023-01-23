package ir.androad.domain.data_store

import kotlinx.coroutines.flow.Flow

interface UserDataStore {

    suspend fun saveUserState(email: String, password: String)
    fun readUserState(): Flow<Boolean>
    suspend fun readUserEmail(): Flow<String?>
    suspend fun readUserPassword(): Flow<String?>
}