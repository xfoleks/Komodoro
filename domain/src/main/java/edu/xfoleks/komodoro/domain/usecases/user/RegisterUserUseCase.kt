package edu.xfoleks.komodoro.domain.usecases.user

import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.repository.UserRepository

class RegisterUserUseCase constructor(
    private val repository: UserRepository
) {
    suspend fun invoke(user: User) = repository.createUser(user)
}