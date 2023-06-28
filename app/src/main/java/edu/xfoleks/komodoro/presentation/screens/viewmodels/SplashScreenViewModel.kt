package edu.xfoleks.komodoro.presentation.screens.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.xfoleks.komodoro.presentation.utils.onboardingmanager.OnBoardingManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val onBoardingManager: OnBoardingManager
) : ViewModel() {

    private var _isLoading = MutableLiveData(true)
    val isLoading = _isLoading

    private var _onBoardingStatus = MutableLiveData<Boolean>()
    val onBoardingStatus = _onBoardingStatus

    init {
        getOnBoardingProgress()
    }

    private fun getOnBoardingProgress() {
        viewModelScope.launch {
            onBoardingManager.onBoardingStatus.collect { finished ->
                _onBoardingStatus.value = finished
            }
        }

        _isLoading.value = false
    }
}