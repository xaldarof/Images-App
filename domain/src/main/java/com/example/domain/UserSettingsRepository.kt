package com.example.domain

interface UserSettingsRepository {
    fun isDarkModelEnabled():Boolean
    fun setMode(mode:Boolean)
}