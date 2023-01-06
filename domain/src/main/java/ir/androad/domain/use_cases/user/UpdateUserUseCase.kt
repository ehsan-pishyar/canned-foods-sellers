package ir.androad.domain.use_cases.user

import ir.androad.domain.models.User
import ir.androad.domain.repositories.UserRepository
import ir.androad.domain.utils.ServiceResult

class UpdateUserUseCase constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User): ServiceResult<Boolean> {
        return userRepository.updateUser(user)
    }
}