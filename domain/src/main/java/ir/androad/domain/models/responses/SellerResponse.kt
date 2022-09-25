package ir.androad.domain.models.responses

data class SellerResponse (
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val deliveryFee: Long?,
    val deliveryDuration: Int?
)

data class SellerListResponse (
    val totalResults: Int?,
    val pages: Int?,
    val sellers: List<SellerResponse?>?
)

data class SellerDetailsResponse (
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val location: LocationResponse?,
    val results: List<ResultResponse?>?,
    val comments: List<SellerCommentResponse?>?,
    val deliveryFee: Long?,
    val deliveryDuration: Int?,
    val phoneNumber: String?,
    val dateCreated: String?
)