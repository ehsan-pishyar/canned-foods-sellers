package ir.androad.domain.models.responses

data class SellerRatingsResponse(
    val id: Long?,
    val fromCustomer: String?,
    val rating: Double?
)

data class ResultRatingsResponse(
    val id: Long?,
    val fromCustomer: String?,
    val rating: Double?
)
