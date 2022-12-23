package ir.androad.cache.models.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Result_Table")
data class ResultResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val title: String?,
    val description: String?,
    @ColumnInfo(name = "image_path")
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    @ColumnInfo(name = "prepare_duration")
    val prepareDuration: Int?,
    val seller: String?,
    @ColumnInfo(name = "food_category")
    val foodCategory: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?
)

@Entity(tableName = "Result_Details_Table")
data class ResultDetailsResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val title: String?,
    val description: String?,
    @ColumnInfo(name = "image_path")
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    @ColumnInfo(name = "prepare_duration")
    val prepareDuration: Int?,
    val seller: SellerResponseEntity?,
    @ColumnInfo(name = "food_category")
    val foodCategory: String?,
    val rating: Double?,
    val comments: List<ResultCommentResponseEntity?>?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?
)