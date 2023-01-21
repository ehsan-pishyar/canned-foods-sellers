package ir.androad.repository.data_store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import ir.androad.domain.data_store.SellerDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class SellerDataStoreDataSource(context: Context): SellerDataStore {

    private object SellerDataStoreKeys{
        val sellerId = longPreferencesKey(name = "seller_id")
    }

    private val dataStore = context.dataStore

    override suspend fun saveSellerId(sellerId: Long) {
        dataStore.edit { preferences ->
            preferences[SellerDataStoreKeys.sellerId] = sellerId
        }
    }

    override suspend fun readSellerId(): Long {
        return dataStore.data
            .map { preferences ->
                val sellerId = preferences[SellerDataStoreKeys.sellerId]
                sellerId
            }
            .catch {
                if (it is IOException) {
                    it.cause
                } else {
                    throw it
                }
            }.toString().toLong()
    }
}