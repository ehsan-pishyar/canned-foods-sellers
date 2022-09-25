package ir.androad.domain.models

data class SellerCategory(
    val id: Int?,
    val title: String?,
    val imagePath: String?
)

data class ResultCategory(
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val sellerCategoryId: Int?
)

data class FoodCategory(
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val resultCategoryId: Int?
)