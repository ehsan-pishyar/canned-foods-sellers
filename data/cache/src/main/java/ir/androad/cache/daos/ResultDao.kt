package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.responses.ResultDetailsResponseEntity
import ir.androad.cache.models.responses.ResultResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(resultEntity: ResultResponseEntity)

    @Query("SELECT * FROM `Result_Table`")
    fun fetchResults(): Flow<List<ResultResponseEntity>?>

    @Query("SELECT * FROM `Result_Table` WHERE id = :resultId")
    fun fetchResultById(resultId: Long?): Flow<ResultResponseEntity>

    @Query("SELECT * FROM `Result_Table` WHERE title like :resultTitle")
    fun fetchResultsByTitle(resultTitle: String?): Flow<List<ResultResponseEntity>?>

    @Query("SELECT * FROM `Result_Details_Table` WHERE id = :resultId")
    fun fetchResultDetails(resultId: Long?): Flow<ResultDetailsResponseEntity>

    @Update
    suspend fun updateResult(resultEntity: ResultResponseEntity)

    @Query("DELETE FROM `Result_Table` WHERE id = :resultId")
    suspend fun deleteResultById(resultId: Long?)

    @Query("DELETE FROM `Result_Table`")
    suspend fun deleteResults()

    @Query("SELECT COUNT(*) FROM `Result_Table`")
    suspend fun isResultCacheAvailable(): Int
}