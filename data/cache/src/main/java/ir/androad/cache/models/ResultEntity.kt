package ir.androad.cache.models

data class ResultEntity(
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
