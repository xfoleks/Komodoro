package edu.xfoleks.komodoro.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.xfoleks.komodoro.domain.interactors.UserInteractor
import edu.xfoleks.komodoro.domain.repository.UserRepository
import edu.xfoleks.komodoro.domain.usecases.user.GetUserUseCase
import edu.xfoleks.komodoro.domain.usecases.user.RegisterUserUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideRegisterUserUseCase(repository: UserRepository) = RegisterUserUseCase(repository)

    @Provides
    @Singleton
    fun provideGetUserUseCase(repository: UserRepository) = GetUserUseCase(repository)

    @Provides
    @Singleton
    fun provideUserInteractor(
        registerUserUseCase: RegisterUserUseCase,
        getUserUseCase: GetUserUseCase
    ) = UserInteractor(registerUserUseCase, getUserUseCase)
}