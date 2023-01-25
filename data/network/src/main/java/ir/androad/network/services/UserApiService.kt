package ir.androad.network.services

import ir.androad.network.models.UserDto
import ir.androad.network.models.responses.UserResponseDto
import retrofit2.http.*

interface UserApiService {

    @POST("/users/create")
    suspend fun insertUser(
        @Body user: UserDto
    ): UserResponseDto

    @GET("/users")
    suspend fun getUserById(
        @Query("user_id") userId: Long
    ): UserResponseDto

    @GET("/users")
    suspend fun getUsersByEmail(
        @Query("email") userEmail: String
    ): UserResponseDto

    @GET("/users")
    suspend fun getUserByEmailAndPassword(
        @Query("email") userEmail: String?,
        @Query("password") userPassword: String?
    ): UserResponseDto

    @PUT("/users/{user_id}/update")
    suspend fun updateUser(
        @Path("user_id") userId: Long,
        @Body user: UserDto
    ): UserResponseDto
}