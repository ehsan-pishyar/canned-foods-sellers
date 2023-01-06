package ir.androad.domain.models

data class User (
    val id: Long = 0L,
    val email: String = "",
    val password: String = "",
    val userType: String = "",
    val dateCreated: String = "",
)