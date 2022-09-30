package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_USER)
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val email: String?,
    val password: String?,
    @ColumnInfo(name = "user_type")
    val userType: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
)
