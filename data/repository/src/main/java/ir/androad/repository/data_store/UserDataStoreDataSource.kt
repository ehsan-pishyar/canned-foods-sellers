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

    override fun readUserState(email: String, password: String): Flow<Boolean> {
        return dataStore.data
            .map { preferences ->
                val userEmailState = preferences[UserKeys.userEmailKey]
                val userPasswordState = preferences[UserKeys.userPasswordKey]

                userEmailState!!.isNotEmpty() &&
                userEmailState == email &&
                userPasswordState!!.isNotEmpty() &&
                userPasswordState == password
            }
            .catch {
                if (it is IOException) {
                    emit(false)
                } else {
                    throw it
                }
            }
    }
}