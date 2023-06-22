package edu.xfoleks.komodoro.domain.mappers

import edu.xfoleks.komodoro.domain.local.entities.UserEntity
import edu.xfoleks.komodoro.domain.model.User

fun UserEntity.toUser(): User = User(
    userName = userName,
    password = password
)

fun User.toUserEntity(): UserEntity = UserEntity(
    uid = 0,
    userName = userName,
    password = password
)