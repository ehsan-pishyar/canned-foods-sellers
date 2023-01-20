package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.responses.SellerDetailsResponseEntity
import ir.androad.cache.models.responses.SellerResponseEntity

@Dao
interface SellerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeller(sellerResponseEntity: SellerResponseEntity)

    @Query("SELECT * FROM `Seller_Table`")
    suspend fun fetchSellers(): List<SellerResponseEntity>?

    @Query("SELECT * FROM `Seller_Details_Table` WHERE id = :sellerId")
    suspend fun fetchSellerDetails(sellerId: Long?): SellerDetailsResponseEntity

    @Update
    suspend fun updateSeller(sellerEntity: SellerResponseEntity?)

    @Query("DELETE FROM `Seller_Table`")
    suspend fun deleteSellers()

    @Query("SELECT COUNT(*) FROM `Seller_Table`")
    suspend fun isSellerCacheAvailable(): Int
}