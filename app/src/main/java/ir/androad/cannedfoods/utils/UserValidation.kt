package ir.androad.cannedfoods.utils

import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun emailRegex(email: String?): Flow<ServiceResult<Boolean>> = flow {
    emit(ServiceResult.Error(data = false))
}

fun passwordHas8Chars(password: String?): Flow<ServiceResult<Boolean>> = flow {
    emit(ServiceResult.Error(data = false))
}

fun passwordHasString(password: String?): Flow<ServiceResult<Boolean>> = flow {
    emit(ServiceResult.Error(data = false))
}