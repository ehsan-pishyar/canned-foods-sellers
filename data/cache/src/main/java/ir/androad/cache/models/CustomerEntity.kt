package ir.androad.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.androad.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_CUSTOMER)
data class CustomerEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0L,

    @ColumnInfo(name = "user_id")
    val userId: Long = 0L,                  // This seller belongs to user {user_id}

    @ColumnInfo(name = "first_name")
    val firstName: String = "",

    @ColumnInfo(name = "last_name")
    val lastName: String = "",

    val email: String = "",
    val picture: String = "",               // User picture image path

    @ColumnInfo(name = "phone_number")
    val phoneNumber: Long = 0L,

    @ColumnInfo(name = "location_id")
    val locationId: Long = 0L,

    val sex: String = "",                   // Man, Woman

    @ColumnInfo(name = "birth_date")
    val birthDate: String = "",

    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)
