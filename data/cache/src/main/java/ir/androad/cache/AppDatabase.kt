package ir.androad.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.androad.cache.daos.*
import ir.androad.cache.models.*
import ir.androad.cache.utils.Constants

@Database(
    entities = [
        SellerCategoryEntity::class,
        ResultCategoryEntity::class,
        FoodCategoryEntity::class,
        SellerCommentEntity::class,
        ResultCommentEntity::class,
        CustomerEntity::class,
        StateEntity::class,
        CityEntity::class,
        LocationEntity::class,
        SellerRatingEntity::class,
        ResultRatingEntity::class,
        ResultEntity::class,
        SellerEntity::class,
        UserEntity::class,
        SellerOpenHoursEntity::class,
        SellerCloseHoursEntity::class,
        CustomerPurchaseHistoryEntity::class
               ],
    version = Constants.DB_VERSION,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun UserDao(): UserDao
    abstract fun sellerDao(): SellerDao

    abstract fun sellerCategoryDao(): SellerCategoryDao
    abstract fun resultCategoryDao(): ResultCategoryDao
    abstract fun foodCategoryDao(): FoodCategoryDao

    abstract fun locationDao(): LocationDao
    abstract fun resultDao(): ResultDao
    abstract fun utilsDao(): UtilsDao

    abstract fun sellerCommentsDao(): SellerCommentsDao
    abstract fun resultCommentsDao(): ResultCommentsDao
    abstract fun sellerRatingsDao(): SellerRatingsDao
    abstract fun resultRatingsDao(): ResultRatingsDao
}