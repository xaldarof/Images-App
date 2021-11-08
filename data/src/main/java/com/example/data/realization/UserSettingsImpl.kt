package com.example.data.realization

import android.content.SharedPreferences
import com.example.data.cache.UserSettings
import com.example.data.utils.UserSettings.DARK_MODE
import com.example.data.utils.UserSettings.DEFAULT_REC
import com.example.data.utils.UserSettings.LANGUAGE
import com.example.data.utils.UserSettings.RECOMMENDS
import javax.inject.Inject

class UserSettingsImpl

@Inject constructor(private val sharedPreferences: SharedPreferences): UserSettings {

    override fun isDarkModelEnabled(): Boolean {
        return sharedPreferences.getBoolean(DARK_MODE,false)
    }

    override fun setMode(mode: Boolean) {
        sharedPreferences.edit().putBoolean(DARK_MODE,mode).apply()
    }

    override fun setUserRecommends(name: String) {
        sharedPreferences.edit().putString(RECOMMENDS,name).apply()
    }

    override fun fetchUserRecommends() = sharedPreferences.getString(RECOMMENDS, DEFAULT_REC)

    override fun setUserLanguage(name: String) = sharedPreferences.edit().putString(LANGUAGE,name).apply()


    override fun fetchUserLanguage():String? = sharedPreferences.getString(LANGUAGE,"en")

}