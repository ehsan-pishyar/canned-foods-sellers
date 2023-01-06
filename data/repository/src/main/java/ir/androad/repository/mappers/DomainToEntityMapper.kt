package ir.androad.repository.mappers

import ir.androad.cache.models.ResultEntity
import ir.androad.cache.models.SellerEntity
import ir.androad.cache.models.UserEntity
import ir.androad.domain.models.Result
import ir.androad.domain.models.Seller
import ir.androad.domain.models.User

fun User.toEntity(): UserEntity =
    UserEntity(
        this.id,
        this.email,
        this.password,
        this.userType,
        this.dateCreated
    )

fun Seller.toEntity(): SellerEntity =
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

fun Result.toEntity(): ResultEntity =
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