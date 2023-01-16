package ir.androad.network.services

import ir.androad.network.models.UserDto
import retrofit2.http.*

interface UserApiService {

    @POST("/users/create")
    suspend fun insertUser(
        @Body user: UserDto
    ): UserDto?

    @GET("/users")
    suspend fun getUserById(
        @Query("user_id") userId: Long
    ): UserDto

    @GET("/users")
    suspend fun getUsersByEmail(
        @Query("email") userEmail: String
    ): List<UserDto>

    @GET("/users")
    suspend fun getUserByEmailAndPassword(
        @Query("email") userEmail: String?,
        @Query("password") userPassword: String?
    ): UserDto

    @PUT("/users/{user_id}/update")
    suspend fun updateUser(
        @Path("user_id") userId: Long,
        @Body user: UserDto
    ): UserDto?
}