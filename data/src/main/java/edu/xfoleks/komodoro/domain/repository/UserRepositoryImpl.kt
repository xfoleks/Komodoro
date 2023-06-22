package edu.xfoleks.komodoro.domain.repository

import edu.xfoleks.komodoro.domain.local.database.AppDatabase
import edu.xfoleks.komodoro.domain.mappers.toUserEntity
import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.domain.repository.UserRepository
import edu.xfoleks.komodoro.domain.mappers.toUser

class UserRepositoryImpl(
    private val database: AppDatabase
): UserRepository {
    override suspend fun createUser(user: User) =
        database.getUserDao().createUser(user.toUserEntity())

    override suspend fun getUser(user: String): User =
        database.getUserDao().getUser(user).toUser()

}