package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto (
    val id: Long?,

    @SerialName("seller_id")
    val sellerId: Long?,

    val title: String?,
    val description: String?,

    @SerialName("seller_category_id")
    val sellerCategoryId: Int?,

    @SerialName("result_category_id")
    val resultCategoryId: Int?,

    @SerialName("food_category_id")
    val foodCategoryId: Int?,

    @SerialName("image_path")
    val imagePath: String?,

    val price: Long?,
    val discount: Int?,
    val rating: Double?,

    @SerialName("prepare_duration")
    val prepareDuration: Int?,

    @SerialName("date_created")
    val dateCreated: String?
)