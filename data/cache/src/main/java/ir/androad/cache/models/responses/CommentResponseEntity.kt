package ir.androad.cache.models.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Seller_Comments_Table")
data class SellerCommentResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val from: String?,
    val message: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?
)

@Entity(tableName = "Result_Comments_Table")
data class ResultCommentResponseEntity (
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val from: String?,
    val message: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?
)