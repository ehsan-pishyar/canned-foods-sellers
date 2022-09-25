package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.SellerCategoryEntity

@Dao
interface SellerCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSellerCategory(sellerCategoryEntity: SellerCategoryEntity)

    @Query("SELECT * FROM `Seller_Category_Table`")
    suspend fun fetchSellerCategories(): List<SellerCategoryEntity>?

    @Query("SELECT * FROM `Seller_Category_Table` WHERE id = :sellerCategoryId")
    suspend fun fetchSellerCategoryById(sellerCategoryId: Int?): SellerCategoryEntity

    @Update(entity = SellerCategoryEntity::class)
    suspend fun updateSellerCategory(sellerCategoryEntity: SellerCategoryEntity)

    @Query("DELETE FROM `Seller_Category_Table` WHERE id = :sellerCategoryId")
    suspend fun deleteSellerCategoryById(sellerCategoryId: Int?)

    @Query("DELETE FROM `Seller_Category_Table`")
    suspend fun deleteSellerCategories()

    @Query("SELECT COUNT(*) FROM `Seller_Category_Table`")
    suspend fun isSellerCategoryCacheAvailable(): Int
}