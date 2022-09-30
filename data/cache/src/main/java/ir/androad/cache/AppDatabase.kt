package ir.androad.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.androad.cache.converters.RoomConverters
import ir.androad.cache.daos.*
import ir.androad.cache.models.*
import ir.androad.cache.models.responses.ResultResponseEntity
import ir.androad.cache.models.responses.SellerResponseEntity
import ir.androad.cache.utils.Constants

@Database(
    entities = [
        UserEntity::class,
               ],
    version = Constants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(RoomConverters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}