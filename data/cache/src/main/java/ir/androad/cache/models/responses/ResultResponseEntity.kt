package ir.androad.cache.models.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

data class ResultResponseEntity (
    val id: Long?,
    val title: String?,
    val description: String?,
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    val prepareDuration: Int?,
    val seller: String?,
    val foodCategory: String?,
    val dateCreated: String?
)

data class ResultDetailsResponseEntity (
    val id: Long?,
    val title: String?,
    val description: String?,
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    val prepareDuration: Int?,
    val seller: SellerResponseEntity?,
    val foodCategory: String?,
    val rating: Double?,
    val comments: List<ResultCommentResponseEntity?>?,
    val dateCreated: String?
)