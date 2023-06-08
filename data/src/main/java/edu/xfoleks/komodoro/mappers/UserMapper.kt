package edu.xfoleks.komodoro.mappers

import edu.xfoleks.komodoro.local.entities.UserEntity
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