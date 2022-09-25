package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_SELLER_RATINGS)
data class SellerRatingEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "from_customer_id")
    val fromCustomerId: Long = 0L,

    val rating: Int = 0,
)

@Entity(tableName = Constants.ENTITY_RESULT_RATINGS)
data class ResultRatingEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "from_customer_id")
    val fromCustomerId: Long = 0,

    val rating: Int = 0,
)