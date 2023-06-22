package edu.xfoleks.komodoro.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.xfoleks.komodoro.presentation.utils.hasher.PasswordHasher
import edu.xfoleks.komodoro.presentation.utils.hasher.PasswordVerifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePasswordHasher() = PasswordHasher()

    @Provides
    @Singleton
    fun providePasswordVerifier() = PasswordVerifier()
}