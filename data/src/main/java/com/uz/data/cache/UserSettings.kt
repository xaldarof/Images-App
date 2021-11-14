package com.uz.data.cache

interface UserSettings {

    fun isDarkModelEnabled():Boolean
    fun setMode(mode:Boolean)

    fun setUserRecommends(name:String)
    fun fetchUserRecommends():String?

    fun setUserLanguage(name:String)
    fun fetchUserLanguage():String?

    fun setSafeModel(mode:Boolean)
    fun isSafeMode():Boolean
}