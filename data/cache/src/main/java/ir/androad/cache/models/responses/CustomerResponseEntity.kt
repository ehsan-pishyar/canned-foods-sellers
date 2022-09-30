package ir.androad.cache.models.responses

data class CustomerResponseEntity (
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: String?,
    val dateCreated: String?
)

data class CustomerDetailsResponseEntity (
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,
    val sex: String?,
    val location: LocationResponseEntity?,
    val dateCreated: String?
)