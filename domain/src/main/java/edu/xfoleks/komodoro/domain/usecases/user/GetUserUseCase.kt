package edu.xfoleks.komodoro.domain.usecases.user

import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.repository.UserRepository

class GetUserUseCase(
        private val userRepository: UserRepository
) {
    suspend fun invoke(user: User) = userRepository.getUser(user.userName)
}