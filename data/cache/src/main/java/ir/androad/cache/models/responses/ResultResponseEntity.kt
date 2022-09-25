package ir.androad.cache.models.responses

data class ResultResponse(
    val id: Long?,
    val title: String?,
    val description: String?,
    val image_path: String?,
    val price: Long?,
    val discount: Int?,
    val prepare_duration: Int?,
    val seller: String?,
    val food_category: String? = null,
    val date_created: String?
)

data class ResultDetailsResponse(
    val id: Long?,
    val title: String?,
    val description: String?,
    val image_path: String?,
    val price: Long?,
    val discount: Int?,
    val prepare_duration: Int?,
    val seller: SellerResponse?,
    val food_category: String?,
    val rating: Double?,
    val comments: List<ResultCommentResponse?> = emptyList(),
    val date_created: String?
)