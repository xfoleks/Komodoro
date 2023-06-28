package edu.xfoleks.komodoro.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.xfoleks.komodoro.presentation.utils.hasher.PasswordHasher
import edu.xfoleks.komodoro.presentation.utils.onboardingmanager.OnBoardingManager
import edu.xfoleks.komodoro.presentation.utils.verifier.PasswordVerifier
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

    @Provides
    @Singleton
    fun provideOnBoardingManager(@ApplicationContext context: Context) =
        OnBoardingManager(context = context)
}