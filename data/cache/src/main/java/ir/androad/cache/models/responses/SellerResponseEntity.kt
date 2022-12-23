package ir.androad.cache.models.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Seller_Table")
data class SellerResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    @ColumnInfo(name = "delivery_fee")
    val deliveryFee: Long?,
    @ColumnInfo(name = "delivery_duration")
    val deliveryDuration: Int?
)

data class SellerListResponseEntity (
    val totalResults: Int?,
    val pages: Int?,
    val sellers: List<SellerResponseEntity?>?
)

@Entity(tableName = "Seller_Details_Table")
data class SellerDetailsResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val location: LocationResponseEntity?,
    val results: List<ResultResponseEntity?>?,
    val comments: List<SellerCommentResponseEntity?>?,
    @ColumnInfo(name = "delivery_fee")
    val deliveryFee: Long?,
    @ColumnInfo(name = "delivery_duration")
    val deliveryDuration: Int?,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?
)