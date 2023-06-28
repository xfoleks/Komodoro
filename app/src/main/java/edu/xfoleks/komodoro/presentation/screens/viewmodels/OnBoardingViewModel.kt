package edu.xfoleks.komodoro.presentation.screens.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.xfoleks.komodoro.presentation.utils.onboardingmanager.OnBoardingManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingManager: OnBoardingManager
) : ViewModel() {

    fun saveOnBoardingProgress(context: Context, completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            onBoardingManager.saveOnBoardingProgress(context = context, completed)
        }
    }
}