package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerCommentDto(
    val id: Long?,

    @SerialName("from_customer_id")
    val fromCustomerId: Long?,

    val message: String?,

    @SerialName("date_created")
    val dateCreated: String?
)

@Serializable
data class ResultCommentDto(
    val id: Long?,

    @SerialName("from_customer_id")
    val fromCustomerId: Long?,

    val message: String?,

    @SerialName("date_created")
    val dateCreated: String?
)