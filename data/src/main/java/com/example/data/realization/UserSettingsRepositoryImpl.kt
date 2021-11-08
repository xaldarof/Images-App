package com.example.data.realization

import com.example.data.cache.UserSettings
import com.example.domain.abstraction.UserSettingsRepository

class UserSettingsRepositoryImpl(private val userSettings: UserSettings): UserSettingsRepository {


    override fun isDarkModelEnabled() = userSettings.isDarkModelEnabled()
    override fun setMode(mode: Boolean) =userSettings.setMode(mode)


    override fun setUserRecommends(name: String)  = userSettings.setUserRecommends(name)
    override fun fetchUserRecommends(): String? = userSettings.fetchUserRecommends()

    override fun setUserLanguage(name: String) = userSettings.setUserLanguage(name)

    override fun fetchUserLanguage(): String? = userSettings.fetchUserLanguage()
}