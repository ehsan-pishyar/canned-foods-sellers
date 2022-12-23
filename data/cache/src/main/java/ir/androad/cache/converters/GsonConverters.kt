package ir.androad.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.androad.cache.models.UserEntity
import ir.androad.cache.models.responses.*

class GsonConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromUser(user: UserEntity?): String?{
        if (user == null) return null

        val type = object : TypeToken<UserEntity?>() {}.type
        return gson.toJson(user, type)
    }

    @TypeConverter
    fun toUser(userItem: String?): UserEntity?{
        if (userItem.isNullOrEmpty()) return null

        val type = object : TypeToken<UserEntity?>() {}.type
        return gson.fromJson(userItem, type)
    }

    @TypeConverter
    fun fromSeller(seller: SellerResponseEntity?): String?{
        if (seller == null) return null

        val type = object : TypeToken<SellerResponseEntity?>() {}.type
        return gson.toJson(seller, type)
    }

    @TypeConverter
    fun toSeller(sellerItem: String?): SellerResponseEntity?{
        if (sellerItem.isNullOrEmpty()) return null

        val type = object : TypeToken<SellerResponseEntity?>() {}.type
        return gson.fromJson(sellerItem, type)
    }

    @TypeConverter
    fun fromSellerDetails(sellerDetails: SellerDetailsResponseEntity?): String?{
        if (sellerDetails == null) return null

        val type = object : TypeToken<UserEntity?>() {}.type
        return gson.toJson(sellerDetails, type)
    }

    @TypeConverter
    fun toSellerDetails(sellerDetailsItem: String?): SellerDetailsResponseEntity?{
        if (sellerDetailsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<UserEntity?>() {}.type
        return gson.fromJson(sellerDetailsItem, type)
    }

    @TypeConverter
    fun fromResults(results: List<ResultResponseEntity>?): String?{
        if (results.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ResultResponseEntity>?>() {}.type
        return gson.toJson(results, type)
    }

    @TypeConverter
    fun toResults(resultsItem: String?): List<ResultResponseEntity>?{
        if (resultsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ResultResponseEntity>?>() {}.type
        return gson.fromJson(resultsItem, type)
    }

    @TypeConverter
    fun fromResultDetails(resultDetails: ResultDetailsResponseEntity?): String?{
        if (resultDetails == null) return null

        val type = object : TypeToken<ResultDetailsResponseEntity?>() {}.type
        return gson.toJson(resultDetails, type)
    }

    @TypeConverter
    fun toResultDetails(resultDetailsItem: String?): ResultDetailsResponseEntity?{
        if (resultDetailsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ResultDetailsResponseEntity?>() {}.type
        return gson.fromJson(resultDetailsItem, type)
    }

    @TypeConverter
    fun fromLocation(location: LocationResponseEntity?): String?{
        if (location == null) return null

        val type = object : TypeToken<LocationResponseEntity?>() {}.type
        return gson.toJson(location, type)
    }

    @TypeConverter
    fun toLocation(locationItem: String?): LocationResponseEntity?{
        if (locationItem.isNullOrEmpty()) return null

        val type = object : TypeToken<LocationResponseEntity?>() {}.type
        return gson.fromJson(locationItem, type)
    }

    @TypeConverter
    fun fromResultComments(resultComments: List<ResultCommentResponseEntity>?): String?{
        if (resultComments.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ResultCommentResponseEntity>?>() {}.type
        return gson.toJson(resultComments, type)
    }

    @TypeConverter
    fun toResultComments(resultCommentsItem: String?): List<ResultCommentResponseEntity>?{
        if (resultCommentsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ResultCommentResponseEntity>?>() {}.type
        return gson.fromJson(resultCommentsItem, type)
    }

    @TypeConverter
    fun fromSellerComments(sellerComments: List<SellerCommentResponseEntity>?): String?{
        if (sellerComments.isNullOrEmpty()) return null

        val type = object : TypeToken<List<SellerCommentResponseEntity>?>() {}.type
        return gson.toJson(sellerComments, type)
    }

    @TypeConverter
    fun toSellerComments(sellerCommentsItem: String?): List<SellerCommentResponseEntity>?{
        if (sellerCommentsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<SellerCommentResponseEntity>?>() {}.type
        return gson.fromJson(sellerCommentsItem, type)
    }
}