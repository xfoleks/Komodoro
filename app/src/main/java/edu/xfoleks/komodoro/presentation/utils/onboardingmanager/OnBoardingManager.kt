package edu.xfoleks.komodoro.presentation.utils.onboardingmanager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(OnBoardingManager.DATA_STORE_NAME)

class OnBoardingManager(context: Context) {

    val onBoardingStatus = context.dataStore.data.map {preferences ->
        preferences[ONBOARDING_FINISHED_KEY] ?: false
    }

    suspend fun saveOnBoardingProgress(context: Context, isFinished: Boolean) {
        context.dataStore.edit { settings ->
            settings[ONBOARDING_FINISHED_KEY] = isFinished
        }
    }

    companion object {
        const val DATA_STORE_NAME = "OnBoarding"
        val ONBOARDING_FINISHED_KEY = booleanPreferencesKey("ONBOARDING_FINISHED")
    }
}