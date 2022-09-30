package ir.androad.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import ir.androad.cache.models.UserEntity

@ProvidedTypeConverter
class RoomConverters(private val moshi: Moshi) {

    @TypeConverter
    fun fromUser(userEntity: UserEntity?): String? =
        moshi.adapter(UserEntity::class.java).toJson(userEntity)

    @TypeConverter
    fun toUser(json: String?): UserEntity? =
        moshi.adapter(UserEntity::class.java).fromJson(json!!)
}