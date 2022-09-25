package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.SellerEntity

@Dao
interface SellerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeller(sellerEntity: SellerEntity)

    @Query("SELECT * FROM `Seller_Table` WHERE id = :sellerId")
    suspend fun fetchSellerById(sellerId: Long?): SellerEntity

    @Update(entity = SellerEntity::class)
    suspend fun updateSeller(sellerEntity: SellerEntity?)

    @Query("SELECT COUNT(*) FROM `Seller_Table`")
    suspend fun isSellerCacheAvailable(): Int
}