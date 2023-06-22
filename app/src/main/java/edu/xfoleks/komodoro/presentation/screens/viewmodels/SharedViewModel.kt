package edu.xfoleks.komodoro.presentation.screens.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.xfoleks.komodoro.domain.interactors.UserInteractor
import edu.xfoleks.komodoro.presentation.exceptions.EmptyPasswordException
import edu.xfoleks.komodoro.presentation.exceptions.UserNotCreatedException
import edu.xfoleks.komodoro.presentation.mappers.toUser
import edu.xfoleks.komodoro.presentation.mappers.toUserInfoItem
import edu.xfoleks.komodoro.presentation.models.UserInfoItem
import edu.xfoleks.komodoro.presentation.utils.hasher.PasswordHasher
import edu.xfoleks.komodoro.presentation.utils.hasher.PasswordVerifier
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val userInteractor: UserInteractor,
    private val passwordHasher: PasswordHasher,
    private val passwordVerifier: PasswordVerifier
) : ViewModel() {

    private var _user = MutableLiveData<UserInfoItem>()

    private fun encryptPassword(password: String): String {
        if (password.isEmpty()) {
            throw EmptyPasswordException()
        }

        return passwordHasher.encrypt(password)
    }

    fun registerUser(userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) {
            throw UserNotCreatedException()
        }

        val encryptedPassword = encryptPassword(password)

        val userData = UserInfoItem(userName, encryptedPassword)
        _user.value = userData

        userInteractor.registerUser(userData.toUser())
    }

    fun logIn(userName: String, password: String): Boolean {
        val user = UserInfoItem(userName, password)
        _user.value = user
        val existingUser = userInteractor.getUser(user.toUser()).toUserInfoItem()
        return user.userName.equals(existingUser.userName) &&
                passwordVerifier.verify(password, existingUser.password)
    }
}