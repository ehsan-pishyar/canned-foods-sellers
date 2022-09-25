package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerCommentResponseDto(
    val from: String?,
    val message: String?,

    @SerialName("date_created")
    val dateCreated: String?
)

@Serializable
data class ResultCommentResponseDto(
    val from: String?,
    val message: String?,

    @SerialName("date_created")
    val dateCreated: String?
)