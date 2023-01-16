package ir.androad.network.services

import ir.androad.network.models.responses.CustomerResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomerApiService {

    @GET("/customers")
    suspend fun getCustomers(): CustomerResponseDto

    @GET("/customers")
    suspend fun getCustomerById(
        @Query("customer_id") customerId: Long
    ): CustomerResponseDto
}