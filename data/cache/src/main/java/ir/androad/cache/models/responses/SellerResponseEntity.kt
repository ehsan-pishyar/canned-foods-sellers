package ir.androad.cache.models.responses

data class SellerResponse(
    val id: Long? = 0L,
    val title: String? = "",
    val description: String? = "",
    val logo: String? = "",
    val banner: String? = "",
    val delivery_fee: Long? = 0L,
    val delivery_duration: Int? = 0
)

data class SellerListResponse(
    val total_results: Int = 0,
    val pages: Int = 1,
    val sellers: List<SellerResponse?> = emptyList()
)

data class SellerDetailsResponse(
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val location: LocationResponse? = null,
    val results: List<ResultResponse?>? = emptyList(),
    val comments: List<SellerCommentResponse?> = emptyList(),
    val delivery_fee: Long?,
    val delivery_duration: Int?,
    val phone_number: String?,
    val date_created: String?
)