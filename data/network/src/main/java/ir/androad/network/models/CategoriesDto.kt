package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerCategoryDto(
    val id: Int?,
    val title: String?,

    @SerialName("image_path")
    val imagePath: String?
)

@Serializable
data class ResultCategoryDto(
    val id: Int?,
    val title: String?,

    @SerialName("image_path")
    val imagePath: String?,

    @SerialName("seller_category_id")
    val sellerCategoryId: Int?
)

@Serializable
data class FoodCategoryDto(
    val id: Int?,
    val title: String?,

    @SerialName("image_path")
    val imagePath: String?,

    @SerialName("result_category_id")
    val resultCategoryId: Int?
)