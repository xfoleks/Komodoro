package edu.xfoleks.komodoro.presentation.utils.verifier

import at.favre.lib.crypto.bcrypt.BCrypt

class PasswordVerifier {

    fun verify(password: String, hashedPassword: String) =
        BCrypt.verifyer().verify(password.toCharArray(), hashedPassword.toCharArray()).verified
}