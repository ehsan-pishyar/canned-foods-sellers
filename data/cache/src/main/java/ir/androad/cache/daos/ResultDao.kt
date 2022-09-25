package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.ResultEntity

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(resultEntity: ResultEntity)

    @Query("SELECT * FROM `Result_Table`")
    suspend fun fetchResults(): List<ResultEntity>?

    @Query("SELECT * FROM `Result_Table` WHERE id = :resultId")
    suspend fun fetchResultById(resultId: Long?): ResultEntity

    @Query("SELECT * FROM `Result_Table` WHERE title like :resultTitle")
    suspend fun fetchResultsByTitle(resultTitle: String?): List<ResultEntity>?

    @Query("SELECT * FROM `Result_Table` WHERE seller_category_id = :sellerCategoryId")
    suspend fun fetchResultsBySellerCategoryId(sellerCategoryId: Int?): List<ResultEntity>?

    @Query("SELECT * FROM `Result_Table` WHERE result_category_id = :resultCategoryId")
    suspend fun fetchResultsByResultId(resultCategoryId: Int?): List<ResultEntity>

    @Update(entity = ResultEntity::class)
    suspend fun updateResult(resultEntity: ResultEntity)

    @Query("DELETE FROM `Result_Table` WHERE id = :resultId")
    suspend fun deleteResultById(resultId: Long?)

    @Query("DELETE FROM `Result_Table`")
    suspend fun deleteResults()

    @Query("SELECT COUNT(*) FROM `Result_Table`")
    suspend fun isResultCacheAvailable(): Int
}