package ir.androad.cache.models

data class SellerOpenHoursEntity(
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

data class SellerCloseHoursEntity(
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

data class CustomerPurchaseHistoryEntity(
    val id: Long?,
    val customerId: Long?,
    val orderId: Long?,
    val sellerId: Long?,
    val orderDate: String?,
    val orderStatus: String?
)