package ir.androad.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import ir.androad.cache.models.UserEntity
import ir.androad.cache.models.responses.ResultDetailsResponseEntity
import ir.androad.cache.models.responses.ResultResponseEntity
import ir.androad.cache.models.responses.SellerDetailsResponseEntity
import ir.androad.cache.models.responses.SellerResponseEntity

@ProvidedTypeConverter
class RoomConverters (private val moshi: Moshi) {

    @TypeConverter
    fun fromUser(userEntity: UserEntity?): String? =
        moshi.adapter(UserEntity::class.java).toJson(userEntity)

    @TypeConverter
    fun toUser(json: String?): UserEntity? =
        moshi.adapter(UserEntity::class.java).fromJson(json!!)

    @TypeConverter
    fun fromSeller(sellerResponseEntity: SellerResponseEntity?): String? =
        moshi.adapter(SellerResponseEntity::class.java).toJson(sellerResponseEntity)

    @TypeConverter
    fun toSeller(json: String?): SellerResponseEntity? =
        moshi.adapter(SellerResponseEntity::class.java).fromJson(json!!)

    @TypeConverter
    fun fromSellerDetails(sellerDetailsResponseEntity: SellerDetailsResponseEntity?): String? =
        moshi.adapter(SellerDetailsResponseEntity::class.java).toJson(sellerDetailsResponseEntity)

    @TypeConverter
    fun toSellerDetails(json: String?): SellerDetailsResponseEntity? =
        moshi.adapter(SellerDetailsResponseEntity::class.java).fromJson(json!!)

    @TypeConverter
    fun fromResult(resultResponseEntity: ResultResponseEntity): String? =
        moshi.adapter(ResultResponseEntity::class.java).toJson(resultResponseEntity)

    @TypeConverter
    fun toResult(json: String?): ResultResponseEntity? =
        moshi.adapter(ResultResponseEntity::class.java).fromJson(json!!)

    @TypeConverter
    fun fromResultDetails(resultDetailsResponseEntity: ResultDetailsResponseEntity?): String? =
        moshi.adapter(ResultDetailsResponseEntity::class.java).toJson(resultDetailsResponseEntity)

    @TypeConverter
    fun toResultDetails(json: String?): ResultDetailsResponseEntity? =
        moshi.adapter(ResultDetailsResponseEntity::class.java).fromJson(json!!)
}