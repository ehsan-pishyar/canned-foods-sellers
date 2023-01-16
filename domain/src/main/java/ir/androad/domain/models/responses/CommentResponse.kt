package ir.androad.domain.models.responses

data class SellerCommentResponse (
    val id: Long,
    val from: String?,
    val message: String?,
    val dateCreated: String?
)

data class ResultCommentResponse (
    val id: Long,
    val from: String?,
    val message: String?,
    val dateCreated: String?
)