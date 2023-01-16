package ir.androad.repository.mappers

import ir.androad.cache.models.*
import ir.androad.cache.models.responses.*
import ir.androad.domain.models.*
import ir.androad.domain.models.responses.*

fun UserEntity.toDomain(): User =
    User(
        this.id!!,
        this.email!!,
        this.password!!,
        this.userType!!,
        this.dateCreated!!
    )

fun SellerOpenHoursEntity.toDomain(): SellerOpenHours =
    SellerOpenHours(
        this.id,
        this.sellerId,
        this.saturday,
        this.sunday,
        this.monday,
        this.tuesday,
        this.wednesday,
        this.thursday,
        this.friday
    )

fun SellerCloseHoursEntity.toDomain(): SellerCloseHours =
    SellerCloseHours(
        this.id,
        this.sellerId,
        this.saturday,
        this.sunday,
        this.monday,
        this.tuesday,
        this.wednesday,
        this.thursday,
        this.friday
    )

fun SellerRatingsResponseEntity.toDomain(): SellerRatingsResponse =
    SellerRatingsResponse(
        this.id,
        this.fromCustomer,
        this.rating
    )

fun CustomerPurchaseHistoryEntity.toDomain(): CustomerPurchaseHistory =
    CustomerPurchaseHistory(
        this.id,
        this.customerId,
        this.orderId,
        this.sellerId,
        this.orderDate,
        this.orderStatus
    )

fun SellerCategoryResponseEntity.toDomain(): SellerCategoryResponse =
    SellerCategoryResponse(
        this.id,
        this.title,
        this.imagePath
    )

fun ResultsCategoryResponseEntity.toDomain(): ResultsCategoryResponse =
    ResultsCategoryResponse(
        this.id,
        this.title,
        this.imagePath,
        this.sellerCategory
    )

fun FoodCategoryResponseEntity.toDomain(): FoodCategoryResponse =
    FoodCategoryResponse(
        this.id,
        this.title,
        this.imagePath,
        this.resultsCategory
    )

fun SellerCommentResponseEntity.toDomain(): SellerCommentResponse =
    SellerCommentResponse(
        this.id,
        this.from,
        this.message,
        this.dateCreated
    )

fun ResultCommentResponseEntity.toDomain(): ResultCommentResponse =
    ResultCommentResponse(
        this.id,
        this.from,
        this.message,
        this.dateCreated
    )

fun ResultRatingsResponseEntity.toDomain(): ResultRatingsResponse =
    ResultRatingsResponse(
        this.id,
        this.fromCustomer,
        this.rating
    )

fun CustomerResponseEntity.toDomain(): CustomerResponse =
    CustomerResponse(
        this.id,
        this.firstName,
        this.lastName,
        this.email,
        this.picture,
        this.sex,
        this.location,
        this.dateCreated
    )

fun CustomerDetailsResponseEntity.toDomain(): CustomerDetailsResponse =
    CustomerDetailsResponse(
        this.id,
        this.firstName,
        this.lastName,
        this.email,
        this.picture,
        this.sex,
        this.location?.toDomain(),
        this.dateCreated
    )

fun StateResponseEntity.toDomain(): StateResponse =
    StateResponse(
        this.id,
        this.title,
        this.cities.map { it.toDomain() }
    )

fun CityResponseEntity.toDomain(): CityResponse =
    CityResponse(
        this.id,
        this.title,
        this.state
    )

fun LocationResponseEntity.toDomain(): LocationResponse =
    LocationResponse(
        this.id,
        this.title,
        this.lat,
        this.lon,
        this.city,
        this.state
    )

fun ResultResponseEntity.toDomain(): ResultResponse =
    ResultResponse(
        this.id,
        this.title,
        this.description,
        this.imagePath,
        this.price,
        this.discount,
        this.prepareDuration,
        this.seller,
        this.foodCategory,
        this.dateCreated
    )

fun ResultDetailsResponseEntity.toDomain(): ResultDetailsResponse =
    ResultDetailsResponse(
        this.id,
        this.title,
        this.description,
        this.imagePath,
        this.price,
        this.discount,
        this.prepareDuration,
        this.seller?.toDomain(),
        this.foodCategory,
        this.rating,
        this.comments?.map { it?.toDomain() },
        this.dateCreated
    )

fun SellerResponseEntity.toDomain(): SellerResponse =
    SellerResponse(
        this.id,
        this.title,
        this.description,
        this.logo,
        this.banner,
        this.deliveryFee,
        this.deliveryDuration
    )

fun SellerListResponseEntity.toDomain(): SellerListResponse =
    SellerListResponse(
        this.totalResults,
        this.pages,
        this.sellers?.map { it?.toDomain() }
    )

fun SellerDetailsResponseEntity.toDomain(): SellerDetailsResponse =
    SellerDetailsResponse(
        this.id,
        this.title,
        this.description,
        this.logo,
        this.banner,
        this.location?.toDomain(),
        this.results?.map { it?.toDomain() },
        this.comments?.map { it?.toDomain() },
        this.deliveryFee,
        this.deliveryDuration,
        this.phoneNumber,
        this.dateCreated
    )

fun UserResponseEntity.toDomain(): UserResponse =
    UserResponse(
        this.user?.toDomain(),
        this.errors?.map { it?.toDomain() }
    )

fun ResponseErrorsEntity.toDomain(): ResponseErrors =
    ResponseErrors(
        this.code,
        this.message
    )