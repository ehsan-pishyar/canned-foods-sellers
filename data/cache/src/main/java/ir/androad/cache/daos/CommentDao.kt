package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.androad.cache.models.responses.ResultCommentResponseEntity
import ir.androad.cache.models.responses.SellerCommentResponseEntity

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSellerComment(commentResponseEntity: SellerCommentResponseEntity)

    @Query("SELECT * FROM `Seller_Comments_Table`")
    suspend fun fetchSellerComments(): List<SellerCommentResponseEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResultComments(resultCommentResponseEntity: ResultCommentResponseEntity)

    @Query("SELECT * FROM `Result_Comments_Table` WHERE id = :resultId")
    suspend fun fetchResultComments(resultId: Long): List<ResultCommentResponseEntity>?
}