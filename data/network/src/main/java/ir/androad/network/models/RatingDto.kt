package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerRatingDto(
    val id: Long?,

    @SerialName("from_customer_id")
    val fromCustomerId: Long?,

    val rating: Int?,
)

@Serializable
data class ResultRatingDto(
    val id: Long?,

    @SerialName("from_customer_id")
    val fromCustomerId: Long?,

    val rating: Int?,
)