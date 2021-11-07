package com.example.data.realization

import com.example.data.cache.UserSettings
import com.example.domain.UserSettingsRepository

class UserSettingsRepositoryImpl(private val userSettings: UserSettings): UserSettingsRepository {


    override fun isDarkModelEnabled(): Boolean {
        return userSettings.isDarkModelEnabled()
    }

    override fun setMode(mode: Boolean) {
        userSettings.setMode(mode)
    }
}