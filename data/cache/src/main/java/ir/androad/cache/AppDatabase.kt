package ir.androad.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.androad.cache.converters.GsonConverters
import ir.androad.cache.daos.*
import ir.androad.cache.models.*
import ir.androad.cache.models.responses.*
import ir.androad.cache.utils.Constants

@Database(
    entities = [
        UserEntity::class,
        SellerResponseEntity::class,
        SellerDetailsResponseEntity::class,
        ResultResponseEntity::class,
        ResultDetailsResponseEntity::class,
        SellerCommentResponseEntity::class,
        ResultCommentResponseEntity::class,
        LocationResponseEntity::class
               ],
    version = Constants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(GsonConverters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun sellerDao(): SellerDao
    abstract fun resultDao(): ResultDao
}