package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_SELLER_CATEGORY)
data class SellerCategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,

    val title: String = "",

    @ColumnInfo(name = "image_path")
    val imagePath: String = ""
)

@Entity(tableName = Constants.ENTITY_RESULT_CATEGORY)
data class ResultCategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,

    val title: String = "",

    @ColumnInfo(name = "image_path")
    val imagePath: String = "",

    @ColumnInfo(name = "seller_category_id")
    val sellerCategoryId: Int = 0
)

@Entity(tableName = Constants.ENTITY_FOOD_CATEGORY)
data class FoodCategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,

    val title: String = "",

    @ColumnInfo(name = "image_path")
    val imagePath: String = "",

    @ColumnInfo(name = "result_category_id")
    val resultCategoryId: Int = 0
)
