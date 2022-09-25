package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.ResultCategoryEntity

@Dao
interface ResultCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResultCategory(resultCategoryEntity: ResultCategoryEntity)

    @Query("SELECT * FROM `Result_Category_Table`")
    suspend fun fetchResultCategories(): List<ResultCategoryEntity>

    @Query("SELECT * FROM `Result_Category_Table` WHERE id = :resultCategoryId")
    suspend fun fetchResultCategoryById(resultCategoryId: Int?): ResultCategoryEntity

    @Query("SELECT * FROM `Result_Category_Table` WHERE seller_category_id = :sellerCategoryId")
    suspend fun fetchResultCategoriesBySellerCategoryId(sellerCategoryId: Int?): List<ResultCategoryEntity>?

    @Query("SELECT * FROM `Result_Category_Table` WHERE title like :resultCategoryTitle")
    suspend fun fetchResultCategoriesByTitle(resultCategoryTitle: String?): List<ResultCategoryEntity>?

    @Update(entity = ResultCategoryEntity::class)
    suspend fun updateResultCategory(resultCategoryEntity: ResultCategoryEntity)

    @Query("DELETE FROM `Result_Category_Table` WHERE id = :resultCategoryId")
    suspend fun deleteResultCategoryById(resultCategoryId: Int?)

    @Query("DELETE FROM `Result_Category_Table`")
    suspend fun deleteResultCategories()

    @Query("SELECT COUNT(*) FROM `Result_Category_Table`")
    suspend fun isResultCategoryCacheAvailable(): Int
}