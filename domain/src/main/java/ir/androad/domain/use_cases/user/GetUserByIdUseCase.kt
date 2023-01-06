package ir.androad.domain.use_cases.user

import ir.androad.domain.models.User
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult

class GetUserByIdUseCase constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(userId: Long): ServiceResult<User> {
        return userRepository.getUserById(userId)
    }
}