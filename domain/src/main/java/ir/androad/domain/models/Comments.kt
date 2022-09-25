package ir.androad.domain.models

data class SellerComment(
    val id: Long?,
    val fromCustomerId: Long?,
    val message: String?,
    val dateCreated: String?
)

data class ResultComment(
    val id: Long?,
    val fromCustomerId: Long?,
    val message: String?,
    val dateCreated: String?
)