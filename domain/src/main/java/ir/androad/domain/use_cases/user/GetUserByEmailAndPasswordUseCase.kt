package ir.androad.domain.use_cases.user

import ir.androad.domain.repositories.UserRepository

class GetUserByEmailAndPasswordUseCase constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String) =
        userRepository.getUserByEmailAndPassword(email, password)
}