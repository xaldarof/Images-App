package com.example.exampletaxi.vm

import androidx.lifecycle.ViewModel
import com.example.domain.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel

@Inject
constructor(private val userSettings: UserSettingsRepository): ViewModel() {

    fun isDarkModelEnabled() = userSettings.isDarkModelEnabled()

    fun setMode(mode:Boolean) = userSettings.setMode(mode)
}