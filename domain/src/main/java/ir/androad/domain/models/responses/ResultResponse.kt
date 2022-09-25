package ir.androad.domain.models.responses

data class ResultResponse (
    val id: Long?,
    val title: String?,
    val description: String?,
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    val prepareDuration: Int?,
    val seller: String?,
    val foodCategory: String?,
    val dateCreated: String?
)

data class ResultDetailsResponse (
    val id: Long?,
    val title: String?,
    val description: String?,
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    val prepareDuration: Int?,
    val seller: SellerResponse?,
    val foodCategory: String?,
    val rating: Double?,
    val comments: List<ResultCommentResponse?>?,
    val dateCreated: String?
)