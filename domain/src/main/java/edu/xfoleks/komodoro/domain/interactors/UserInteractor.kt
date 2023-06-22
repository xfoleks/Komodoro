package edu.xfoleks.komodoro.domain.interactors

import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.usecases.user.GetUserUseCase
import edu.xfoleks.komodoro.domain.usecases.user.RegisterUserUseCase
import kotlinx.coroutines.runBlocking

class UserInteractor constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val getUserUseCase: GetUserUseCase
) {
    fun registerUser(user: User) = runBlocking {
        registerUserUseCase.invoke(user)
    }

    fun getUser(user: User) = runBlocking {
        getUserUseCase.invoke(user)
    }
}