package edu.xfoleks.komodoro.presentation.utils.hasher

import at.favre.lib.crypto.bcrypt.BCrypt

class PasswordHasher {

    fun encrypt(password: String): String =
        BCrypt.withDefaults().hashToString(10, password.toCharArray())
}