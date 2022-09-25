package ir.androad.domain.models

data class SellerRating(
    val id: Long?,
    val fromCustomerId: Long?,
    val rating: Int?,
)

data class ResultRating(
    val id: Long?,
    val fromCustomerId: Long?,
    val rating: Int?,
)