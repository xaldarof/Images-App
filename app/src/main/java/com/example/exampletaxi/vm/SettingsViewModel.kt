package com.example.exampletaxi.vm

import androidx.lifecycle.ViewModel
import com.example.core.BaseViewModel
import com.example.domain.abstraction.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel

@Inject
constructor(private val userSettings: UserSettingsRepository): BaseViewModel() {

    fun isDarkModelEnabled() = userSettings.isDarkModelEnabled()

    fun setMode(mode:Boolean) = userSettings.setMode(mode)

    fun setUserRecommends(name:String) = userSettings.setUserRecommends(name)
    fun fetchUserRecommends():String? = userSettings.fetchUserRecommends()

    fun setUserLanguage(langCode:String) = userSettings.setUserLanguage(langCode)
    fun fetchUserLanguage() = userSettings.fetchUserLanguage()
}