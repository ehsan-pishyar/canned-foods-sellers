package ir.androad.domain.utils

import ir.androad.domain.models.User

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

    operator fun invoke(user: User): ServiceResult<Boolean> {
        return if (user.email!!.isBlank() || !user.email.matches(EMAIL_REGEX)) {
            ServiceResult.Error(false)
//            ServiceResult.Error(ErrorCode.INVALID_EMAIL)
        } else {
            ServiceResult.Success(true)
        }
    }
}