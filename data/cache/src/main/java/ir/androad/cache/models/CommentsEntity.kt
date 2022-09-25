package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_SELLER_COMMENTS)
data class SellerCommentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "from_customer_id")
    val fromCustomerId: Long = 0L,

    val message: String = "",

    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)

@Entity(tableName = Constants.ENTITY_RESULT_COMMENTS)
data class ResultCommentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "from_customer_id")
    val fromCustomerId: Long = 0L,

    val message: String = "",

    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)