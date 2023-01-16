package ir.androad.network.services

import ir.androad.network.models.SellerDto
import ir.androad.network.models.responses.SellerCommentResponseDto
import ir.androad.network.models.responses.SellerRatingsResponseDto
import ir.androad.network.models.responses.SellerResponseDto
import retrofit2.http.*

interface SellerApiService {

    @POST("/sellers/create")
    suspend fun insertSeller(
        @Body sellerDto: SellerDto
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellers(): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellerById(
        @Query("id") id: Long
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByTitle(
        @Query("title") title: String?
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByDescription(
        @Query("description") description: String?
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByLocationTitle(
        @Query("location_title") locationTitle: String?
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByResultTitle(
        @Query("result_title") resultTitle: String?
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersBySellerCategoryId(
        @Query("sc_id") sellerCategoryId: Int
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByResultCategoryId(
        @Query("rc_id") resultCategoryId: Int
    ): SellerResponseDto

    @GET("/sellers")
    suspend fun getSellersByFoodCategoryId(
        @Query("fc_id") foodCategoryId: Int
    ): SellerResponseDto

    @GET("/sellers/{seller_id}/comments/")
    suspend fun getSellerComments(
        @Path("seller_id") sellerId: Long
    ): SellerCommentResponseDto

    @GET("/sellers/{seller_id}/ratings")
    suspend fun getSellerRatings(
        @Path("seller_id") sellerId: Long
    ): SellerRatingsResponseDto

    @PUT("/sellers/{seller_id}/update")
    suspend fun updateSeller(
        @Path("seller_id") sellerId: Long,
        @Body sellerDto: SellerDto
    ): SellerResponseDto
}