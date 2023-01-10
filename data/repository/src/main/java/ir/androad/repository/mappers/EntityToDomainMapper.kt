package ir.androad.repository.mappers

import ir.androad.cache.models.*
import ir.androad.cache.models.responses.*
import ir.androad.domain.models.*
import ir.androad.domain.models.responses.*

fun SellerCategoryEntity.toDomain(): SellerCategory =
    SellerCategory(
        this.id,
        this.title,
        this.imagePath
    )

fun ResultCategoryEntity.toDomain(): ResultCategory =
    ResultCategory(
        this.id,
        this.title,
        this.imagePath,
        this.sellerCategoryId
    )

fun FoodCategoryEntity.toDomain(): FoodCategory =
    FoodCategory(
        this.id,
        this.title,
        this.imagePath,
        this.resultCategoryId
    )

fun SellerCommentEntity.toDomain(): SellerComment =
    SellerComment(
        this.id,
        this.fromCustomerId,
        this.message,
        this.dateCreated
    )

fun ResultCommentEntity.toDomain(): ResultComment =
    ResultComment(
        this.id,
        this.fromCustomerId,
        this.message,
        this.dateCreated
    )

fun CustomerEntity.toDomain(): Customer =
    Customer(
        this.id,
        this.userId,
        this.firstName,
        this.lastName,
        this.email,
        this.picture,
        this.phoneNumber,
        this.locationId,
        this.sex,
        this.birthDate,
        this.dateCreated
    )

fun StateEntity.toDomain(): State =
    State(
        this.id,
        this.title
    )

fun CityEntity.toDomain(): City =
    City(
        this.id,
        this.title,
        this.stateId
    )

fun LocationEntity.toDomain(): Location =
    Location(
        this.id,
        this.title,
        this.lat,
        this.lon,
        this.cityId
    )

fun SellerRatingEntity.toDomain(): SellerRating =
    SellerRating(
        this.id,
        this.fromCustomerId,
        this.rating
    )

fun ResultRatingEntity.toDomain(): ResultRating =
    ResultRating(
        this.id,
        this.fromCustomerId,
        this.rating
    )

fun ResultEntity.toDomain(): Result =
    Result(
        this.id,
        this.sellerId,
        this.title,
        this.description,
        this.sellerCategoryId,
        this.resultCategoryId,
        this.foodCategoryId,
        this.imagePath,
        this.price,
        this.discount,
        this.rating,
        this.prepareDuration,
        this.dateCreated
    )

fun SellerEntity.toDomain(): Seller =
    Seller(
        this.id,
        this.userId,
        this.title,
        this.description,
        this.logo,
        this.banner,
        this.stateId,
        this.cityId,
        this.locationId,
        this.sellerCategoryId,
        this.resultCategoryId,
        this.foodCategoryId,
        this.deliveryFee,
        this.deliveryDuration,
        this.phoneNumber,
        this.dateCreated
    )

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

fun CustomerPurchaseHistoryEntity.toDomain(): CustomerPurchaseHistory =
    CustomerPurchaseHistory(
        this.id,
        this.customerId,
        this.orderId,
        this.sellerId,
        this.orderDate,
        this.orderStatus
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
        this.from,
        this.message,
        this.dateCreated
    )

fun ResultCommentResponseEntity.toDomain(): ResultCommentResponse =
    ResultCommentResponse(
        this.from,
        this.message,
        this.dateCreated
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
        this.cities?.toDomain()
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