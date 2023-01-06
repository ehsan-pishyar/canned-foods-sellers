package ir.androad.domain.data_store

import kotlinx.coroutines.flow.Flow

interface UserDataStore {

    suspend fun saveUserState(email: String, password: String)
    fun readUserState(email: String, password: String): Flow<Boolean>
}