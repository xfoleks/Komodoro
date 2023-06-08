package edu.xfoleks.komodoro.presentation.mappers

import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.presentation.models.UserInfoItem

fun UserInfoItem.toUser(): User = User(
    userName = userName,
    password = password
)

fun User.toUserInfoItem(): UserInfoItem = UserInfoItem(
    userName = userName,
    password = password
)