package ir.androad.domain.models.responses

data class CustomerResponse (
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: String?,
    val dateCreated: String?
)

data class CustomerDetailsResponse (
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: LocationResponse?,
    val dateCreated: String?
)