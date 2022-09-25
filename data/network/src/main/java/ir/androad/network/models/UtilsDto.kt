package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerOpenHoursDto (
    val id: Long?,

    @SerialName("seller_id")
    val sellerId: Long?,

    val saturday: Int?,
    val sunday: Int?,
    val monday: Int?,
    val tuesday: Int?,
    val wednesday: Int?,
    val thursday: Int?,
    val friday: Int?
)

@Serializable
data class SellerCloseHoursDto (
    val id: Long?,

    @SerialName("seller_id")
    val sellerId: Long?,

    val saturday: Int?,
    val sunday: Int?,
    val monday: Int?,
    val tuesday: Int?,
    val wednesday: Int?,
    val thursday: Int?,
    val friday: Int?
)

@Serializable
data class CustomerPurchaseHistoryDto (
    val id: Long?,

    @SerialName("customer_id")
    val customerId: Long?,

    @SerialName("order_id")
    val orderId: Long?,

    @SerialName("seller_id")
    val sellerId: Long?,

    @SerialName("order_date")
    val orderDate: String?,

    @SerialName("order_status")
    val orderStatus: String?
)