package ir.androad.cache.models.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

data class SellerResponseEntity (
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val deliveryFee: Long?,
    val deliveryDuration: Int?
)

data class SellerListResponseEntity (
    val totalResults: Int?,
    val pages: Int?,
    val sellers: List<SellerResponseEntity?>?
)

data class SellerDetailsResponseEntity (
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val location: LocationResponseEntity?,
    val results: List<ResultResponseEntity?>?,
    val comments: List<SellerCommentResponseEntity?>?,
    val deliveryFee: Long?,
    val deliveryDuration: Int?,
    val phoneNumber: String?,
    val dateCreated: String?
)