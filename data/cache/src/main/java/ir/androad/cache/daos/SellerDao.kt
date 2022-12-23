package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.responses.SellerDetailsResponseEntity
import ir.androad.cache.models.responses.SellerResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SellerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeller(sellerResponseEntity: SellerResponseEntity)

    @Query("SELECT * FROM `Seller_Table`")
    fun fetchSellers(): Flow<List<SellerResponseEntity>?>

    @Query("SELECT * FROM `Seller_Table` WHERE id = :sellerId")
    fun fetchSellerById(sellerId: Long?): Flow<SellerResponseEntity>

    @Query("SELECT * FROM `Seller_Details_Table` WHERE id = :sellerId")
    fun fetchSellerDetails(sellerId: Long?): Flow<SellerDetailsResponseEntity>

    @Update()
    suspend fun updateSeller(sellerEntity: SellerResponseEntity?)

    @Query("SELECT COUNT(*) FROM `Seller_Table`")
    suspend fun isSellerCacheAvailable(): Int
}