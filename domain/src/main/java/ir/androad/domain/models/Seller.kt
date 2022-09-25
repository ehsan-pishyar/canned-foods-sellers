package ir.androad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerDto (
    val id: Long?,

    @SerialName("user_id")
    val userId: Long?,

    val title: String?,
    val description: String?,
    val logo: String?,
    val banner: String?,

    @SerialName("state_id")
    val stateId: Int?,

    @SerialName("city_id")
    val cityId: Int?,

    @SerialName("location_id")
    val locationId: Long?,

    @SerialName("seller_category_id")
    val sellerCategoryId: Int?,

    @SerialName("result_category_id")
    val resultCategoryId: Int?,

    @SerialName("food_category_id")
    val foodCategoryId: Int?,

    @SerialName("delivery_fee")
    val deliveryFee: Long?,

    @SerialName("delivery_duration")
    val deliveryDuration: Int?,

    @SerialName("phone_number")
    val phoneNumber: String?,

    @SerialName("date_created")
    val dateCreated: String?
)