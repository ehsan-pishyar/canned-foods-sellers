package ir.androad.cache.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.androad.cache.AppDatabase
import ir.androad.cache.converters.GsonConverters
import ir.androad.cache.daos.ResultDao
import ir.androad.cache.daos.SellerDao
import ir.androad.cache.daos.UserDao
import ir.androad.cache.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun appDatabaseProvider(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, AppDatabase::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun userDaoProvider(database: AppDatabase): UserDao =
        database.userDao()

    @Provides
    @Singleton
    fun resultDaoProvider(database: AppDatabase): ResultDao =
        database.resultDao()

    @Provides
    @Singleton
    fun sellerDaoProvider(database: AppDatabase): SellerDao =
        database.sellerDao()
}