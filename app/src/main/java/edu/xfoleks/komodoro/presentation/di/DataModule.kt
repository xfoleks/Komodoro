package edu.xfoleks.komodoro.presentation.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.xfoleks.komodoro.domain.repository.UserRepository
import edu.xfoleks.komodoro.domain.local.database.AppDatabase
import edu.xfoleks.komodoro.domain.repository.UserRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "komodoro.db"
    ).build()

    @Provides
    @Singleton
    fun provideUserRepository(database: AppDatabase): UserRepository = UserRepositoryImpl(database)
}