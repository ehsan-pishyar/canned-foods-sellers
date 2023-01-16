package ir.androad.network.services

import ir.androad.network.models.LocationDto
import ir.androad.network.models.responses.CityResponseDto
import ir.androad.network.models.responses.LocationResponseDto
import ir.androad.network.models.responses.StateResponseDto
import retrofit2.http.*

interface LocationApiService {

    @GET("/states")
    suspend fun getStates(): StateResponseDto

    @GET("/states")
    suspend fun getStatesByTitle(
        @Query("title") stateTitle: String?
    ): StateResponseDto

    @GET("/cities")
    suspend fun getCities(
        @Query("state_id") stateId: Int
    ): CityResponseDto

    @GET("/cities")
    suspend fun getCityById(
        @Query("state_id") stateId: Int,
        @Query("id") cityId: Int
    ): CityResponseDto

    @GET("/cities")
    suspend fun getCitiesByTitle(
        @Query("title") cityTitle: String?
    ): CityResponseDto

    @POST("/locations/create")
    suspend fun insertLocation(
        @Body locationDto: LocationDto
    ): LocationResponseDto

    @GET("/locations")
    suspend fun getLocations(
        @Query("city_id") cityId: Int
    ): LocationResponseDto

    @GET("/locations")
    suspend fun getLocationById(
        @Query("id") locationId: Long
    ): LocationResponseDto

    @GET("/locations")
    suspend fun getLocationsByTitle(
        @Query("title") title: String?
    ): LocationResponseDto

    @PUT("/locations/{location_id}/update")
    suspend fun updateLocation(
        @Path("location_id") locationId: Long,
        @Body locationDto: LocationDto
    ): LocationResponseDto

    @DELETE("/locations/{location_id}/delete")
    suspend fun deleteLocation(
        @Path("location_id") locationId: Long
    )
}