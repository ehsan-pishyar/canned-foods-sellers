package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_RESULT)
data class ResultEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = randomIdGenerator(),

    @ColumnInfo(name = "seller_id")
    val sellerId: Long = 0L,

    val title: String = "",
    val description: String = "",

    @ColumnInfo(name = "seller_category_id")
    val sellerCategoryId: Int = 0,

    @ColumnInfo(name = "result_category_id")
    val resultCategoryId: Int = 0,

    @ColumnInfo(name = "food_category_id")
    val foodCategoryId: Int = 0,

    @ColumnInfo(name = "image_path")
    val imagePath: String = "",

    val price: Long = 0L,
    val discount: Int = 0,
    val rating: Double = 0.0,

    @ColumnInfo(name = "prepare_duration")
    val prepareDuration: Int = 0,

    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)
