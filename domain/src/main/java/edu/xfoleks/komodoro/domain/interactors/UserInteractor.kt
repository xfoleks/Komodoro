package edu.xfoleks.komodoro.domain.interactors

import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.usecases.user.RegisterUserUseCase
import kotlinx.coroutines.runBlocking

class UserInteractor constructor(
    private val registerUserUseCase: RegisterUserUseCase
) {
    fun registerUser(user: User) = runBlocking {
        registerUserUseCase.invoke(user)
    }
}