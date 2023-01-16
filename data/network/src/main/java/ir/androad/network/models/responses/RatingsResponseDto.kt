package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerRatingsResponseDto (
    val id: Long?,
    @SerialName("from_customer")
    val fromCustomer: String?,
    val rating: Double?
)

@Serializable
data class ResultRatingsResponseDto (
    val id: Long?,
    @SerialName("from_customer")
    val fromCustomer: String?,
    val rating: Double?
)