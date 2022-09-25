package ir.androad.cache.models.responses

data class ResultsCategoryResponse(
    val id: Int?,
    val title: String?,
    val image_path: String?,
    val seller_category: String?
)

data class FoodCategoryResponse(
    val id: Int?,
    val title: String?,
    val image_path: String?,
    val results_category: String?
)