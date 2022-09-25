package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_SELLER)
data class SellerEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = randomIdGenerator(),

    @ColumnInfo(name = "user_id")
    val userId: Long = 0L,                      // This seller belongs to user {user_id}

    val title: String = "",
    val description: String = "",
    val logo: String = "",                      // Logo image path
    val banner: String = "",

    @ColumnInfo(name = "state_id")
    val stateId: Int = 0,

    @ColumnInfo(name = "city_id")               // Belongs to State {state_id}
    val cityId: Int = 0,

    @ColumnInfo(name = "location_id")           // Belongs to city {city_id}
    val locationId: Long = 0L,

    @ColumnInfo(name = "seller_category_id")    // Belongs to location {location_id}
    val sellerCategoryId: Int = 0,

    @ColumnInfo(name = "result_category_id")
    val resultCategoryId: Int = 0,

    @ColumnInfo(name = "food_category_id")
    val foodCategoryId: Int = 0,

    @ColumnInfo(name = "delivery_fee")
    val deliveryFee: Long = 0L,

    @ColumnInfo(name = "delivery_duration")
    val deliveryDuration: Int = 0,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String = "",

    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)
