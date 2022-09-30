package ir.androad.cache.models

data class CustomerEntity(
    val id: Long?,
    val userId: Long?,                  // This seller belongs to user {user_id}
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val picture: String?,               // User picture image path
    val phoneNumber: Long?,
    val locationId: Long?,
    val sex: String?,                   // Man, Woman
    val birthDate: String?,
    val dateCreated: String?
)
