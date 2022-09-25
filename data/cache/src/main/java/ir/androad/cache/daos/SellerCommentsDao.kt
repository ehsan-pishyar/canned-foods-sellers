package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.androad.cache.models.SellerCommentEntity

@Dao
interface SellerCommentsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSellerComment(sellerCommentEntity: SellerCommentEntity)

    @Query("SELECT * FROM `Seller_Comments_Table`")
    suspend fun fetchSellerComments(): List<SellerCommentEntity>?

    @Query("SELECT * FROM `Seller_Comments_Table` WHERE id = :sellerCommentId")
    suspend fun fetchSellerCommentById(sellerCommentId: Long?): SellerCommentEntity

    @Query("SELECT COUNT(*) FROM `Seller_Comments_Table`")
    suspend fun isSellerCommentCacheAvailable(): Int
}