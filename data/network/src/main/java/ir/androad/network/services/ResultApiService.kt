package ir.androad.network.services

import ir.androad.network.models.ResultDto
import ir.androad.network.models.responses.ResultCommentResponseDto
import ir.androad.network.models.responses.ResultDetailsResponseDto
import ir.androad.network.models.responses.ResultRatingsResponseDto
import ir.androad.network.models.responses.ResultResponseDto
import retrofit2.http.*

interface ResultApiService {

    @POST("/results/create")
    suspend fun insertResult(
        @Body result: ResultDto
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResults(): ResultResponseDto

    @GET("/results/{result_id}")
    suspend fun getResultDetails(
        @Path("result_id") resultId: Long
    ): ResultDetailsResponseDto

    @GET("/results")
    suspend fun getResultsByTitle(
        @Query("title") resultTitle: String?
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsBySellerId(
        @Query("seller_id") sellerId: Long
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsBySellerCategoryId(
        @Query("sc_id") sellerCategoryId: Int
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsByResultCategoryId(
        @Query("rc_id") resultCategoryId: Int
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsByFoodCategoryId(
        @Query("fc_id") foodCategoryId: Int
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsByVoteCount(
        @Query("vote_count") vote_count: Long
    ): ResultResponseDto

    @GET("/results")
    suspend fun getResultsByRating(
        @Query("rating") rating: Double
    ): ResultResponseDto

    @GET("/results/{result_id}/comments")
    suspend fun getResultComments(
        @Path("result_id") resultId: Long
    ): ResultCommentResponseDto

    @GET("/results/{result_id}/ratings")
    suspend fun getResultRatings(
        @Path("result_id") resultId: Long
    ): ResultRatingsResponseDto

    @PUT("/results/{result_id}/update")
    suspend fun updateResult(
        @Path("result_id") resultId: Long,
        @Body result: ResultDto
    ): ResultResponseDto

    @DELETE("/results/{result_id}/delete")
    suspend fun deleteResultById(
        @Path("result_id") resultId: Long
    )
}