package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_SELLER_OPEN_HOURS)
data class SellerOpenHoursEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = randomIdGenerator(),

    @ColumnInfo(name = "seller_id")
    val sellerId: Long = 0L,

    val saturday: Int = 0,
    val sunday: Int = 0,
    val monday: Int = 0,
    val tuesday: Int = 0,
    val wednesday: Int = 0,
    val thursday: Int = 0,
    val friday: Int = 0
)

@Entity(tableName = Constants.ENTITY_SELLER_CLOSE_HOURS)
data class SellerCloseHoursEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = randomIdGenerator(),

    @ColumnInfo(name = "seller_id")
    val seller_id: Long = 0L,

    val saturday: Int = 0,
    val sunday: Int = 0,
    val monday: Int = 0,
    val tuesday: Int = 0,
    val wednesday: Int = 0,
    val thursday: Int = 0,
    val friday: Int = 0
)

@Entity(tableName = Constants.ENTITY_CUSTOMER_PURCHASE_HISTORY)
data class CustomerPurchaseHistoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "customer_id")
    val customerId: Long = 0L,

    @ColumnInfo(name = "order_id")
    val orderId: Long = 0L,

    @ColumnInfo(name = "seller_id")
    val sellerId: Long = 0L,

    @ColumnInfo(name = "order_date")
    val orderDate: String = "",

    @ColumnInfo(name = "order_status")
    val orderStatus: String = ""
)