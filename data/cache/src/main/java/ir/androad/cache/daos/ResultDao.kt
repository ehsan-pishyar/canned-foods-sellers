package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.responses.ResultDetailsResponseEntity
import ir.androad.cache.models.responses.ResultResponseEntity

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(resultEntity: ResultResponseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResultDetails(resultDetailsResponseEntity: ResultDetailsResponseEntity)

    @Query("SELECT * FROM `Result_Table`")
    suspend fun fetchResults(): List<ResultResponseEntity>?

    @Query("SELECT * FROM `Result_Table` WHERE id = :resultId")
    suspend fun fetchResultById(resultId: Long?): ResultResponseEntity

    @Query("SELECT * FROM `Result_Table` WHERE title like :resultTitle")
    suspend fun fetchResultsByTitle(resultTitle: String?): List<ResultResponseEntity>?

    @Query("SELECT * FROM `Result_Details_Table` WHERE id = :resultId")
    suspend fun fetchResultDetails(resultId: Long?): ResultDetailsResponseEntity

    @Update
    suspend fun updateResult(resultEntity: ResultResponseEntity)

    @Query("DELETE FROM `Result_Table` WHERE id = :resultId")
    suspend fun deleteResultById(resultId: Long?)

    @Query("DELETE FROM `Result_Table`")
    suspend fun deleteResults()

    @Query("SELECT COUNT(*) FROM `Result_Table`")
    suspend fun isResultCacheAvailable(): Int
}