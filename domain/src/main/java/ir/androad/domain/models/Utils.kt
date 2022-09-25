package ir.androad.domain.models

data class SellerOpenHours (
    val id: Long?,
    val sellerId: Long?,
    val saturday: Int?,
    val sunday: Int?,
    val monday: Int?,
    val tuesday: Int?,
    val wednesday: Int?,
    val thursday: Int?,
    val friday: Int?
)

data class SellerCloseHours (
    val id: Long?,
    val sellerId: Long?,
    val saturday: Int?,
    val sunday: Int?,
    val monday: Int?,
    val tuesday: Int?,
    val wednesday: Int?,
    val thursday: Int?,
    val friday: Int?
)

data class CustomerPurchaseHistory (
    val id: Long?,
    val customerId: Long?,
    val orderId: Long?,
    val sellerId: Long?,
    val orderDate: String?,
    val orderStatus: String?
)