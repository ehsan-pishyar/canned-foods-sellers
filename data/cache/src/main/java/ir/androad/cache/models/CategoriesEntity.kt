package ir.androad.cache.models

data class SellerCategoryEntity(
    val id: Int?,
    val title: String?,
    val imagePath: String?
)

data class ResultCategoryEntity(
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val sellerCategoryId: Int?
)

data class FoodCategoryEntity(
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val resultCategoryId: Int?
)
