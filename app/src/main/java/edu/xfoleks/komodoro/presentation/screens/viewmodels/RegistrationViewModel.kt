package edu.xfoleks.komodoro.presentation.screens.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.xfoleks.komodoro.domain.interactors.UserInteractor
import edu.xfoleks.komodoro.domain.model.User
import edu.xfoleks.komodoro.presentation.exceptions.EmptyPasswordException
import edu.xfoleks.komodoro.presentation.exceptions.UserNotCreatedException
import edu.xfoleks.komodoro.presentation.mappers.toUser
import edu.xfoleks.komodoro.presentation.models.UserInfoItem
import edu.xfoleks.komodoro.presentation.utils.CryptoManager
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    private var _user = MutableLiveData<UserInfoItem>()

    private fun encryptPassword(context: Context, password: String): String {
        if (password.isEmpty()) {
            throw EmptyPasswordException()
        }
        val cryptoManager = CryptoManager()
        val bytes = password.encodeToByteArray()
        val file = File(context.filesDir, "secret.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        val fos = FileOutputStream(file)
        val encryptedPassword = cryptoManager.encrypt(
                bytes = bytes,
                outputStream = fos
            )

        return encryptedPassword.toString()
    }

    fun registerUser(context: Context, userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) { throw UserNotCreatedException()}
        val encryptedPassword = encryptPassword(context, password)
        val user = UserInfoItem(userName, encryptedPassword)
        _user.value = user
        userInteractor.registerUser(user.toUser())
    }

}