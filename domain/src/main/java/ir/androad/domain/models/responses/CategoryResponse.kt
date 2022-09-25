package ir.androad.domain.models.responses

data class ResultsCategoryResponse (
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val sellerCategory: String?
)

data class FoodCategoryResponse (
    val id: Int?,
    val title: String?,
    val imagePath: String?,
    val resultsCategory: String?
)