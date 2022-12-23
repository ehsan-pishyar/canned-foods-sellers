package ir.androad.repository.mappers

import ir.androad.cache.models.*
import ir.androad.cache.models.responses.*
import ir.androad.network.models.*
import ir.androad.network.models.responses.*
import java.util.UUID

fun SellerCategoryDto.toEntity(): SellerCategoryEntity =
    SellerCategoryEntity(
        this.id,
        this.title,
        this.imagePath
    )

fun ResultCategoryDto.toEntity(): ResultCategoryEntity =
    ResultCategoryEntity(
        this.id,
        this.title,
        this.imagePath,
        this.sellerCategoryId
    )

fun FoodCategoryDto.toEntity(): FoodCategoryEntity =
    FoodCategoryEntity(
        this.id,
        this.title,
        this.imagePath,
        this.resultCategoryId
    )

fun SellerCommentDto.toEntity(): SellerCommentEntity =
    SellerCommentEntity(
        this.id,
        this.fromCustomerId,
        this.message,
        this.dateCreated
    )

fun ResultCommentDto.toEntity(): ResultCommentEntity =
    ResultCommentEntity(
        this.id,
        this.fromCustomerId,
        this.message,
        this.dateCreated
    )

fun CustomerDto.toEntity(): CustomerEntity =
    CustomerEntity(
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

fun StateDto.toEntity(): StateEntity =
    StateEntity(
        this.id,
        this.title
    )

fun CityDto.toEntity(): CityEntity =
    CityEntity(
        this.id,
        this.title,
        this.stateId
    )

fun LocationDto.toEntity(): LocationEntity =
    LocationEntity(
        this.id,
        this.title,
        this.lat,
        this.lon,
        this.cityId
    )

fun SellerRatingDto.toEntity(): SellerRatingEntity =
    SellerRatingEntity(
        this.id,
        this.fromCustomerId,
        this.rating
    )

fun ResultRatingDto.toEntity(): ResultRatingEntity =
    ResultRatingEntity(
        this.id,
        this.fromCustomerId,
        this.rating
    )

fun ResultDto.toEntity(): ResultEntity =
    ResultEntity(
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

fun SellerDto.toEntity(): SellerEntity =
    SellerEntity(
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

fun UserDto.toEntity(): UserEntity =
    UserEntity(
        this.id,
        this.email,
        this.password,
        this.userType,
        this.dateCreated
    )

fun SellerOpenHoursDto.toEntity(): SellerOpenHoursEntity =
    SellerOpenHoursEntity(
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

fun SellerCloseHoursDto.toEntity(): SellerCloseHoursEntity =
    SellerCloseHoursEntity(
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

fun CustomerPurchaseHistoryDto.toEntity(): CustomerPurchaseHistoryEntity =
    CustomerPurchaseHistoryEntity(
        this.id,
        this.customerId,
        this.orderId,
        this.sellerId,
        this.orderDate,
        this.orderStatus
    )

fun ResultsCategoryResponseDto.toEntity(): ResultsCategoryResponseEntity =
    ResultsCategoryResponseEntity(
        this.id,
        this.title,
        this.imagePath,
        this.sellerCategory
    )

fun FoodCategoryResponseDto.toEntity(): FoodCategoryResponseEntity =
    FoodCategoryResponseEntity(
        this.id,
        this.title,
        this.imagePath,
        this.resultsCategory
    )

fun SellerCommentResponseDto.toEntity(id: UUID): SellerCommentResponseEntity =
    SellerCommentResponseEntity(
        id,
        this.from,
        this.message,
        this.dateCreated
    )

fun ResultCommentResponseDto.toEntity(id: UUID): ResultCommentResponseEntity =
    ResultCommentResponseEntity(
        id,
        this.from,
        this.message,
        this.dateCreated
    )

fun CustomerResponseDto.toEntity(): CustomerResponseEntity =
    CustomerResponseEntity(
        this.id,
        this.firstName,
        this.lastName,
        this.email,
        this.picture,
        this.sex,
        this.location,
        this.dateCreated
    )

fun CustomerDetailsResponseDto.toEntity(): CustomerDetailsResponseEntity =
    CustomerDetailsResponseEntity(
        this.id,
        this.firstName,
        this.lastName,
        this.email,
        this.picture,
        this.sex,
        this.location?.toEntity(),
        this.dateCreated
    )

fun StateResponseDto.toEntity(): StateResponseEntity =
    StateResponseEntity(
        this.id,
        this.title,
        this.cities?.toEntity()
    )

fun CityResponseDto.toEntity(): CityResponseEntity =
    CityResponseEntity(
        this.id,
        this.title,
        this.state
    )

fun LocationResponseDto.toEntity(): LocationResponseEntity =
    LocationResponseEntity(
        this.id,
        this.title,
        this.lat,
        this.lon,
        this.city,
        this.state
    )

fun ResultResponseDto.toEntity(): ResultResponseEntity =
    ResultResponseEntity(
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

fun ResultDetailsResponseDto.toEntity(): ResultDetailsResponseEntity =
    ResultDetailsResponseEntity(
        this.id,
        this.title,
        this.description,
        this.imagePath,
        this.price,
        this.discount,
        this.prepareDuration,
        this.seller?.toEntity(),
        this.foodCategory,
        this.rating,
        this.comments?.map { it?.toEntity(id = UUID(8L, 256L)) },
        this.dateCreated
    )

fun SellerResponseDto.toEntity(): SellerResponseEntity =
    SellerResponseEntity(
        this.id,
        this.title,
        this.description,
        this.logo,
        this.banner,
        this.deliveryFee,
        this.deliveryDuration
    )

fun SellerListResponseDto.toEntity(): SellerListResponseEntity =
    SellerListResponseEntity(
        this.totalResults,
        this.pages,
        this.sellers?.map { it?.toEntity() }
    )

fun SellerDetailsResponseDto.toEntity(): SellerDetailsResponseEntity =
    SellerDetailsResponseEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        logo = this.logo,
        banner = this.banner,
        location = this.location?.toEntity(),
        results = this.results?.map { it?.toEntity() },
        comments = this.comments?.map { it?.toEntity(id = UUID(8L, 256L)) },
        deliveryFee = this.deliveryFee,
        deliveryDuration = this.deliveryDuration,
        phoneNumber = this.phoneNumber,
        dateCreated = this.dateCreated
    )

fun UserResponseDto.toEntity(): UserResponseEntity =
    UserResponseEntity(
        user = this.user?.toEntity(),
        errors = this.errors?.map { it?.toEntity() }
    )

fun ResponseErrorsDto.toEntity(): ResponseErrorsEntity =
    ResponseErrorsEntity(
        code = this.code,
        message = this.message
    )