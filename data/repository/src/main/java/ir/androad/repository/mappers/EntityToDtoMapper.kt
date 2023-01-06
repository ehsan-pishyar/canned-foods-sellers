package ir.androad.repository.mappers

import ir.androad.cache.models.ResultEntity
import ir.androad.cache.models.SellerEntity
import ir.androad.cache.models.UserEntity
import ir.androad.network.models.ResultDto
import ir.androad.network.models.SellerDto
import ir.androad.network.models.UserDto

fun UserEntity.toDto(): UserDto =
    UserDto(
        this.id,
        this.email,
        this.password,
        this.userType,
        this.dateCreated
    )

fun SellerEntity.toDto(): SellerDto =
    SellerDto(
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

fun ResultEntity.toDto(): ResultDto =
    ResultDto(
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