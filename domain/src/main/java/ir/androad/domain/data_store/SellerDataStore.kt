package ir.androad.domain.data_store

interface SellerDataStore {

    suspend fun saveSellerId(sellerId: Long)
    suspend fun readSellerId(): Long
}