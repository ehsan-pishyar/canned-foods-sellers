package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerResponseDto(
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,

    @SerialName("delivery_fee")
    val deliveryFee: Long?,

    @SerialName("delivery_duration")
    val deliveryDuration: Int?
)

@Serializable
data class SellerListResponseDto(
    @SerialName("total_results")
    val totalResults: Int?,
    val pages: Int?,
    val sellers: List<SellerResponseDto?>?
)

@Serializable
data class SellerDetailsResponseDto(
    val id: Long?,
    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,
    val location: LocationResponseDto?,
    val results: List<ResultResponseDto?>?,
    val comments: List<SellerCommentResponseDto?>?,

    @SerialName("delivery_fee")
    val deliveryFee: Long?,

    @SerialName("delivery_duration")
    val deliveryDuration: Int?,

    @SerialName("phone_number")
    val phoneNumber: String?,

    @SerialName("date_created")
    val dateCreated: String?
)