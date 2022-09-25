package ir.androad.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.androad.cache.models.ResultRatingEntity

@Dao
interface ResultRatingsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResultRating(resultRatingEntity: ResultRatingEntity)

    @Query("SELECT * FROM `Result_Ratings_Table`")
    suspend fun fetchResultRatings(): List<ResultRatingEntity>?

    @Query("SELECT * FROM `Result_Ratings_Table` WHERE id = :resultRatingId")
    suspend fun fetchResultRatingById(resultRatingId: Long?): ResultRatingEntity

    @Query("SELECT COUNT(*) FROM `Result_Ratings_Table`")
    suspend fun isResultRatingCacheAvailable(): Int
}