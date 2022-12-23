package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM `User_Table` WHERE id = :userId")
    fun fetchUserById(userId: Long?): Flow<UserEntity>

    @Update()
    suspend fun updateUser(userEntity: UserEntity?)

    @Query("SELECT COUNT(*) FROM `User_Table`")
    suspend fun isUserCacheAvailable(): Int
}