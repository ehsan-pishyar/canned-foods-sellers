package ir.androad.repository.utils

import ir.androad.cache.models.UserEntity
import ir.androad.domain.utils.ServiceResult

class ValidateUserEmail {
    companion object {
        private val EMAIL_REGEX = Regex(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
    }

    operator fun invoke(userEntity: UserEntity): ServiceResult<Boolean> {
        return if (userEntity.email.isBlank() || !userEntity.email.matches(EMAIL_REGEX)) {
            ServiceResult.Error(false)
//            ServiceResult.Error(ErrorCode.INVALID_EMAIL)
        } else {
            ServiceResult.Success(true)
        }
    }
}