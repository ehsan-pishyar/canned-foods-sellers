package ir.androad.domain.utils

sealed class ServiceResult<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(isLoading: Boolean): ServiceResult<T>()
    class Success<T>(data: T? = null): ServiceResult<T>(data = data)
    class Error<T>(data: T? = null, message: String? = null): ServiceResult<T>(data = null, message = message)
}
