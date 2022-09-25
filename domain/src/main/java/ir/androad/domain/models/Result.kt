package ir.androad.domain.models


data class Result (
    val id: Long?,
    val sellerId: Long?,
    val title: String?,
    val description: String?,
    val sellerCategoryId: Int?,
    val resultCategoryId: Int?,
    val foodCategoryId: Int?,
    val imagePath: String?,
    val price: Long?,
    val discount: Int?,
    val rating: Double?,
    val prepareDuration: Int?,
    val dateCreated: String?
)