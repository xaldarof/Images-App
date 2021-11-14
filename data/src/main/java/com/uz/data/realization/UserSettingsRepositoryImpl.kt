package com.uz.data.realization

import com.uz.data.cache.UserSettings
import com.uz.domain.abstraction.UserSettingsRepository

class UserSettingsRepositoryImpl(private val userSettings: UserSettings): UserSettingsRepository {

    override fun isDarkModelEnabled() = userSettings.isDarkModelEnabled()
    override fun setMode(mode: Boolean) = userSettings.setMode(mode)

    override fun setUserRecommends(name: String)  = userSettings.setUserRecommends(name)
    override fun fetchUserRecommends(): String? = userSettings.fetchUserRecommends()

    override fun setUserLanguage(name: String) = userSettings.setUserLanguage(name)
    override fun fetchUserLanguage(): String? = userSettings.fetchUserLanguage()

    override fun setSafeModel(mode: Boolean) = userSettings.setSafeModel(mode)
    override fun isSafeMode(): Boolean = userSettings.isSafeMode()

}