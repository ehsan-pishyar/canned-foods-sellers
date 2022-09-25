package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponseDto(
    val id: Long?,
    val title: String?,
    val description: String?,

    @SerialName("image_path")
    val imagePath: String?,

    val price: Long?,
    val discount: Int?,

    @SerialName("prepare_duration")
    val prepareDuration: Int?,

    val seller: String?,

    @SerialName("food_category")
    val foodCategory: String?,

    @SerialName("date_created")
    val dateCreated: String?
)

@Serializable
data class ResultDetailsResponseDto(
    val id: Long?,
    val title: String?,
    val description: String?,

    @SerialName("image_path")
    val imagePath: String?,

    val price: Long?,
    val discount: Int?,

    @SerialName("prepare_duration")
    val prepareDuration: Int?,

    val seller: SellerResponseDto?,

    @SerialName("food_category")
    val foodCategory: String?,

    val rating: Double?,
    val comments: List<ResultCommentResponseDto?>?,

    @SerialName("date_created")
    val dateCreated: String?
)