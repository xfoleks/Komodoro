package edu.xfoleks.komodoro.domain.repository

import edu.xfoleks.komodoro.domain.model.User

interface UserRepository {
    suspend fun createUser(user: User)
}