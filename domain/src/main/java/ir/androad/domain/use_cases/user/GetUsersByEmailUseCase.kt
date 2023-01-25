package ir.androad.domain.use_cases.user

import ir.androad.domain.models.responses.UserResponse
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetUsersByEmailUseCase constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(email: String?): Flow<ServiceResult<List<UserResponse>>> {
        return userRepository.getUsersByEmail(email)
    }
}