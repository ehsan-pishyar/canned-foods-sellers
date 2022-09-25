package ir.androad.domain.models

data class Seller (
    val id: Long?,
    val userId: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val stateId: Int?,
    val cityId: Int?,
    val locationId: Long?,
    val sellerCategoryId: Int?,
    val resultCategoryId: Int?,
    val foodCategoryId: Int?,
    val deliveryFee: Long?,
    val deliveryDuration: Int?,
    val phoneNumber: String?,
    val dateCreated: String?
)