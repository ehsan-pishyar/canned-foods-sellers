package ir.androad.network.services

import ir.androad.network.models.FoodCategoryDto
import ir.androad.network.models.responses.FoodCategoryResponseDto
import ir.androad.network.models.responses.ResultsCategoryResponseDto
import ir.androad.network.models.responses.SellerCategoryResponseDto
import retrofit2.http.*

interface CategoryApiService {

    @GET("/seller-categories")
    suspend fun getSellerCategories(): SellerCategoryResponseDto

    @GET("/seller-categories")
    suspend fun getSellerCategoryById(
        @Query("id") sellerCategoryId: Int
    ): SellerCategoryResponseDto

    @GET("/result-categories")
    suspend fun getResultCategories(
        @Query("sc_id") sellerCategoryId: Int
    ): ResultsCategoryResponseDto

    @GET("/result-categories")
    suspend fun getResultCategoryById(
        @Query("id") id: Int
    ): ResultsCategoryResponseDto

    @GET("/result-categories")
    suspend fun getResultCategoriesByTitle(
        @Query("title") resultCategoryTitle: String?
    ): ResultsCategoryResponseDto

    @GET("/food-categories")
    suspend fun getFoodCategories(
        @Query("rc_id") resultCategoryId: Int
    ): FoodCategoryResponseDto

    @GET("/food-categories")
    suspend fun getFoodCategoryById(
        @Query("id") foodCategoryId: Int
    ): FoodCategoryResponseDto

    @GET("/food-categories")
    suspend fun getFoodCategoriesByTitle(
        @Query("fc_title") foodCategoryTitle: String?
    ): FoodCategoryResponseDto

    @PUT("/food-categories/{food_categories_id}/update")
    suspend fun updateFoodCategory(
        @Path("food_category_id") foodCategoryId: Int,
        @Body foodCategoryDto: FoodCategoryDto
    ): FoodCategoryResponseDto
}