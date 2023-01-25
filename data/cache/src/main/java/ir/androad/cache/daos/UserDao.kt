package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.responses.UserResponseEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userResponseEntity: UserResponseEntity)

    @Query("SELECT * FROM `User_Table` WHERE id = :userId")
    fun fetchUserById(userId: Long?): UserResponseEntity

    @Update
    suspend fun updateUser(userResponseEntity: UserResponseEntity?)

    @Query("SELECT COUNT(*) FROM `User_Table`")
    suspend fun isUserCacheAvailable(): Int
}