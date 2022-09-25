package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.androad.cache.models.SellerRatingEntity

@Dao
interface SellerRatingsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSellerRating(sellerRatingEntity: SellerRatingEntity)

    @Query("SELECT * FROM `Seller_Ratings_Table`")
    suspend fun fetchSellerRatings(): List<SellerRatingEntity>?

    @Query("SELECT * FROM `Seller_Ratings_Table` WHERE id = :sellerRatingId")
    suspend fun fetchSellerRatingById(sellerRatingId: Long?): SellerRatingEntity

    @Query("SELECT COUNT(*) FROM `Seller_Ratings_Table`")
    suspend fun isSellerRatingCacheAvailable(): Int
}