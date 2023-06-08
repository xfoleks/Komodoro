package edu.xfoleks.komodoro.repository

import edu.xfoleks.komodoro.local.database.AppDatabase
import edu.xfoleks.komodoro.mappers.toUserEntity
import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.repository.UserRepository

class UserRepositoryImpl(
    private val database: AppDatabase
): UserRepository {
    override suspend fun createUser(user: User) =
        database.getUserDao().createUser(user.toUserEntity())
}