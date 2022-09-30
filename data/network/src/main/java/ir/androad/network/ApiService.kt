package ir.androad.network

import ir.androad.network.models.*
import ir.androad.network.models.responses.UserResponseDto
import retrofit2.http.*

interface ApiService {

    // User Section ---------------------------------------------------------------------------- >
    @POST("/users/create")
    suspend fun insertUser(
        @Body user: UserDto
    ): UserResponseDto

    @GET("/users")
    suspend fun getUserById(
        @Query("user_id") userId: Long
    ): UserDto

    @PUT("/users/{user_id}/update")
    suspend fun updateUser(
        @Path("user_id") userId: Long,
        @Body user: UserDto
    ): UserDto


    // Seller Section -------------------------------------------------------------------------- >
    @POST("/sellers/create")
    suspend fun insertSeller(
        @Body sellerDto: SellerDto
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellers(): SellerDto

    @GET("/sellers")
    suspend fun getSellerById(
        @Query("id") id: Long
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByTitle(
        @Query("title") title: String?
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByDescription(
        @Query("description") description: String?
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByLocationTitle(
        @Query("location_title") locationTitle: String?
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByResultId(
        @Query("result_id") resultId: Long
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersBySellerCategoryId(
        @Query("sc_id") sellerCategoryId: Int
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByResultCategoryId(
        @Query("rc_id") resultCategoryId: Int
    ): SellerDto

    @GET("/sellers")
    suspend fun getSellersByFoodCategoryId(
        @Query("fc_id") foodCategoryId: Int
    ): SellerDto

    @PUT("/sellers/{seller_id}/update")
    suspend fun updateSeller(
        @Path("seller_id") sellerId: Long,
        @Body sellerDto: SellerDto
    ): SellerDto


    // Location Section ------------------------------------------------------------------------ >
    @GET("/states")
    suspend fun getStates(): StateDto

    @GET("/states")
    suspend fun getStateById(
        @Query("id") stateId: Int
    ): StateDto

    @GET("/states")
    suspend fun getStatesByTitle(
        @Query("title") stateTitle: String?
    ): StateDto

    @GET("/cities")
    suspend fun getCities(
        @Query("state_id") stateId: Int
    ): CityDto

    @GET("/cities")
    suspend fun getCityById(
        @Query("state_id") stateId: Int,
        @Query("id") cityId: Int
    ): CityDto

    @GET("/cities")
    suspend fun getCitiesByTitle(
        @Query("state_id") stateId: Int,
        @Query("title") cityTitle: String?
    ): CityDto

    @GET("/locations")
    suspend fun getLocations(
        @Query("city_id") cityId: Int
    ): LocationDto

    @GET("/locations")
    suspend fun getLocationById(
        @Query("id") locationId: Long
    ): LocationDto

    @GET("/locations")
    suspend fun getLocationsByTitle(
        @Query("title") title: String?
    ): LocationDto

    @PUT("/locations/{location_id}/update")
    suspend fun updateLocation(
        @Path("location_id") locationId: Long,
        @Body locationDto: LocationDto
    ): LocationDto


    // Categories Section ---------------------------------------------------------------------- >
    @GET("/seller-categories")
    suspend fun getSellerCategories(): SellerCategoryDto

    @GET("/seller-categories")
    suspend fun getSellerCategoryById(
        @Query("id") sellerCategoryId: Int
    ): SellerCategoryDto

    @GET("/result-categories")
    suspend fun getResultCategories(
        @Query("sc_id") sellerCategoryId: Int
    ): ResultCategoryDto

    @GET("/result-categories")
    suspend fun getResultCategoryById(
        @Query("id") id: Int
    ): ResultCategoryDto

    @GET("/food-categories")
    suspend fun getFoodCategories(
        @Query("rc_id") resultCategoryId: Int
    ): FoodCategoryDto

    @GET("/food-categories")
    suspend fun getFoodCategoryById(
        @Query("id") foodCategoryId: Int
    ): FoodCategoryDto

    @PUT("/food-categories/{food_category_id}/update")
    suspend fun updateFoodCategory(
        @Path("food_category_id") foodCategoryId: Int,
        @Body foodCategoryDto: FoodCategoryDto
    ): FoodCategoryDto


    // Result Section -------------------------------------------------------------------------- >
    @POST("/results/create")
    suspend fun insertResult(
        @Body result: ResultDto
    ): ResultDto

    @GET("/results")
    suspend fun getResults(): ResultDto

    @GET("/results/{result_id}")
    suspend fun getResultDetails(
        @Path("result_id") resultId: Long
    ): ResultDto

    @GET("/results")
    suspend fun getResultsByTitle(
        @Query("title") resultTitle: String?
    ): ResultDto

    @GET("/results")
    suspend fun getResultsBySellerId(
        @Query("seller_id") sellerId: Long
    ): ResultDto

    @GET("/results")
    suspend fun getResultsBySellerCategoryId(
        @Query("sc_id") sellerCategoryId: Int
    ): ResultDto

    @GET("/results")
    suspend fun getResultsByResultCategoryId(
        @Query("rc_id") resultCategoryId: Int
    ): ResultDto

    @GET("/results")
    suspend fun getResultsByFoodCategoryId(
        @Query("fc_id") foodCategoryId: Int
    ): ResultDto

    @GET("/results")
    suspend fun getResultsByVoteCount(
        @Query("vote_count") vote_count: Long
    ): ResultDto

    @GET("/results")
    suspend fun getResultsByRating(
        @Query("rating") rating: Double
    ): ResultDto

    @PUT("/results/{result_id}/update")
    suspend fun updateResult(
        @Path("result_id") resultId: Long,
        @Body result: ResultDto
    ): ResultDto

    @DELETE("/results/{result_id}/delete")
    suspend fun deleteResultById(
        @Path("result_id") resultId: Long
    ): ResultDto


    // Comments Section ------------------------------------------------------------------------ >
    @GET("/seller-comments/{seller_id}/comments")
    suspend fun getSellerComments(
        @Path("seller_id") sellerId: Long
    ): SellerCommentDto

    @GET("/result-comments/{result_id}/comments")
    suspend fun getResultComments(
        @Path("result_id") resultId: Long
    ): ResultCommentDto


    // Ratings Section ------------------------------------------------------------------------- >
    @GET("/seller-ratings/{seller_id}/ratings")
    suspend fun getSellerRatings(
        @Path("seller_id") sellerId: Long
    ): SellerRatingDto

    @GET("/result-ratings/{result_id}/ratings")
    suspend fun getResultRatings(
        @Path("result_id") resultId: Long
    ): ResultRatingDto


    // Customer Purchase History Section ------------------------------------------------------- >
}