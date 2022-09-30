package ir.androad.cache.models


data class SellerCommentEntity(
    val id: Long?,
    val fromCustomerId: Long?,
    val message: String?,
    val dateCreated: String?
)

data class ResultCommentEntity(
    val id: Long?,
    val fromCustomerId: Long?,
    val message: String?,
    val dateCreated: String?
)