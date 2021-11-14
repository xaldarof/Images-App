package com.uz.data.realization

import android.content.SharedPreferences
import com.uz.data.cache.UserSettings
import com.uz.data.utils.UserSettings.DARK_MODE
import com.uz.data.utils.UserSettings.DEFAULT_REC
import com.uz.data.utils.UserSettings.EN
import com.uz.data.utils.UserSettings.LANGUAGE
import com.uz.data.utils.UserSettings.RECOMMENDS
import com.uz.data.utils.UserSettings.SAFE_MODE
import javax.inject.Inject

class UserSettingsImpl

@Inject constructor(private val sharedPreferences: SharedPreferences): UserSettings {

    override fun isDarkModelEnabled() = sharedPreferences.getBoolean(DARK_MODE,false)
    override fun setMode(mode: Boolean) = sharedPreferences.edit().putBoolean(DARK_MODE,mode).apply()


    override fun setUserRecommends(name: String) = sharedPreferences.edit().putString(RECOMMENDS,name).apply()
    override fun fetchUserRecommends() = sharedPreferences.getString(RECOMMENDS, DEFAULT_REC)


    override fun setUserLanguage(name: String) = sharedPreferences.edit().putString(LANGUAGE,name).apply()
    override fun fetchUserLanguage():String? = sharedPreferences.getString(LANGUAGE,EN)


    override fun setSafeModel(mode: Boolean) = sharedPreferences.edit().putBoolean(SAFE_MODE,mode).apply()
    override fun isSafeMode(): Boolean = sharedPreferences.getBoolean(SAFE_MODE,false)

}