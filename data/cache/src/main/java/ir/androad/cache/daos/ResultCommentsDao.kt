package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.androad.cache.models.ResultCommentEntity

@Dao
interface ResultCommentsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResultComment(resultCommentEntity: ResultCommentEntity)

    @Query("SELECT * FROM `Result_Comments_Table`")
    suspend fun fetchResultComments(): List<ResultCommentEntity>

    @Query("SELECT COUNT(*) FROM `Result_Comments_Table`")
    suspend fun isResultCommentsCacheAvailable(): Int
}