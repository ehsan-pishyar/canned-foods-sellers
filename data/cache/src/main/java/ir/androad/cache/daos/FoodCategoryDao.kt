package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.FoodCategoryEntity

@Dao
interface FoodCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFoodCategory(foodCategoryEntity: FoodCategoryEntity)

    @Query("SELECT * FROM `Food_Category_Table` WHERE result_category_id = :resultCategoryId")
    suspend fun fetchFoodCategories(resultCategoryId: Int?): List<FoodCategoryEntity>

    @Query("SELECT * FROM `Food_Category_Table` WHERE id = :foodCategoryId")
    suspend fun fetchFoodCategoryById(foodCategoryId: Int?): FoodCategoryEntity

    @Query("SELECT * FROM `Food_Category_Table` WHERE title like :foodCategoryTitle")
    suspend fun fetchFoodCategoriesByTitle(foodCategoryTitle: String?): List<FoodCategoryEntity>

    @Update(entity = FoodCategoryEntity::class)
    suspend fun updateFoodCategory(foodCategoryEntity: FoodCategoryEntity)

    @Query("DELETE FROM `Food_Category_Table` WHERE id = :foodCategoryId")
    suspend fun deleteFoodCategory(foodCategoryId: Int?)

    @Query("DELETE FROM `Food_Category_Table`")
    suspend fun deleteFoodCategories()

    @Query("SELECT COUNT(*) FROM `Food_Category_Table`")
    suspend fun isFoodCategoryCacheAvailable(): Int
}