package ir.androad.repository.utils

enum class ErrorCode(val message: String) {
    INVALID_USER("Invalid user object. Check your JSON values."),
    INVALID_EMAIL("Invalid Email format. Check Your email address again"),
    UNKNOWN("An unknown error has occurred."),
    UNKNOWN_USER("This user doesn't exist."),
    DATABASE_ERROR("Unknown database error. Try again, and check your parameters."),
    INVALID_JSON("Your JSON must match the format in this sample response."),
    INVALID_CITY_QUERY("You must pass a city name or zip prefix."),
    USER_EXISTS("This user is already exists."),
    SELLER_EXISTS("Seller already exists"),
    SELLER_404("Seller not found"),
    JSON_ERROR("Error! Check your JSON codes")
//    INVALID_API_KEY("Bad API key. Use x-api-key in the header.")
}