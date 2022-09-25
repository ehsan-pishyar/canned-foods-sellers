package ir.androad.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsCategoryResponseDto(
    val id: Int?,
    val title: String?,

    @SerialName("image_path")
    val imagePath: String?,

    @SerialName("seller_category")
    val sellerCategory: String?
)

@Serializable
data class FoodCategoryResponseDto(
    val id: Int?,
    val title: String?,

    @SerialName("image_path")
    val imagePath: String?,

    @SerialName("results_category")
    val resultsCategory: String?
)