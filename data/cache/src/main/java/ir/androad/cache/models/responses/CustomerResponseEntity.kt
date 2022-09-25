package ir.androad.cache.models.responses

data class CustomerResponse(
    val id: Long?,
    val first_name: String?,
    val last_name: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: String?,
    val date_created: String?
)

data class CustomerDetailsResponse(
    val id: Long?,
    val first_name: String?,
    val last_name: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: LocationResponse? = null,
    val date_created: String?
)