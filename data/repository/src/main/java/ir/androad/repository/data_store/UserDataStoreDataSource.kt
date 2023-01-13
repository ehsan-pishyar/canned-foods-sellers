package ir.androad.repository.data_store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import ir.androad.domain.data_store.UserDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserDataStoreDataSource @Inject constructor(
    context: Context
): UserDataStore {

    private object UserKeys{
        val userEmailKey = stringPreferencesKey(name = "user_email")
        val userPasswordKey = stringPreferencesKey(name = "user_password")
    }

    private val dataStore = context.dataStore

    override suspend fun saveUserState(email: String, password: String) {
        dataStore.edit { preferences ->
            preferences[UserKeys.userEmailKey] = email
            preferences[UserKeys.userPasswordKey] = password
        }
    }

    override fun readUserState(): Flow<Boolean> {
        var isLoggedIn = false
        return dataStore.data
            .map { preferences ->
                val userEmailState = preferences[UserKeys.userEmailKey]
                val userPasswordState = preferences[UserKeys.userPasswordKey]
                if (userEmailState!!.trim().isNotEmpty() && userPasswordState!!.trim().isNotEmpty()) {
                    isLoggedIn = true
                }
                isLoggedIn
            }
            .catch {
                if (it is IOException) {
                    emit(false)
                } else {
                    throw it
                }
            }
    }

    override suspend fun readUserEmail(): String {
        return dataStore.data
            .map { preferences ->
                val email = preferences[UserKeys.userEmailKey]
                email
            }.catch {
                if (it is IOException) {
                    emit("")
                } else {
                    throw it
                }
            }.toString()
    }

    override suspend fun readUserPassword(): String {
        return dataStore.data
            .map { preferences ->
                val password = preferences[UserKeys.userPasswordKey]
                password
            }.catch {
                if (it is IOException) {
                    emit("")
                } else {
                    throw it
                }
            }.toString()
    }
}