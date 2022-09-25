package ir.androad.domain.models

data class Customer(
    val id: Long?,
    val userId: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,
    val phoneNumber: Long?,
    val locationId: Long?,
    val sex: String?,
    val birthDate: String?,
    val dateCreated: String?
)
