package ir.androad.domain.data_store

import kotlinx.coroutines.flow.Flow

interface SellerDataStore {

    suspend fun saveSellerId(sellerId: Long)
    suspend fun readSellerId(): Flow<Long?>
}