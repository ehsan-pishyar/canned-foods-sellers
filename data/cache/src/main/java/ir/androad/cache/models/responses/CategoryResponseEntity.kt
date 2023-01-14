package ir.androad.cache.models.responses

data class SellerCategoryResponseEntity (
    val id: Int?,
    val title: String?,
    val imagePath: String?
)

data class ResultsCategoryResponseEntity (
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val sellerCategory: String?
)

data class FoodCategoryResponseEntity (
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val resultsCategory: String?
)