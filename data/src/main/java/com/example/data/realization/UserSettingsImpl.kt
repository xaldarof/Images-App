package com.example.data.realization

import android.content.SharedPreferences
import com.example.data.cache.UserSettings
import com.example.data.utils.UserSettings.DARK_MODE
import javax.inject.Inject

class UserSettingsImpl

@Inject constructor(private val sharedPreferences: SharedPreferences): UserSettings {

    override fun isDarkModelEnabled(): Boolean {
        return sharedPreferences.getBoolean(DARK_MODE,false)
    }

    override fun setMode(mode: Boolean) {
        sharedPreferences.edit().putBoolean(DARK_MODE,mode).apply()
    }
}