package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants
import ir.androad.cache.utils.randomIdGenerator

@Entity(tableName = Constants.ENTITY_USER)
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = randomIdGenerator(),

    val email: String = "",
    val password: String = "",

    @ColumnInfo(name = "user_type")
    val userType: String = "",             // Admin, Seller, Customer

    @ColumnInfo(name = "date_created")
    val dateCreated: String = "",
)
