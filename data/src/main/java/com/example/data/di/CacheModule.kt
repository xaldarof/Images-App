package com.example.data.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.data.cache.AppDatabase
import com.example.data.cache.ImageDao
import com.example.data.cache.UserSettings
import com.example.data.cloud.abstraction.ImageManager
import com.example.data.realization.ImageManagerImpl
import com.example.data.realization.UserSettingsImpl
import com.example.data.realization.UserSettingsRepositoryImpl
import com.example.data.utils.DataConstants.SETTINGS_NAME
import com.example.domain.UserSettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object CacheModule {

    @Provides
    fun provideImageSaver(imageSaverImpl: ImageManagerImpl): ImageManager {
        return imageSaverImpl
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideImagesDao(appDatabase: AppDatabase): ImageDao {
        return appDatabase.provideImageDao()
    }

    @Provides
    @Singleton
    fun provideSharedPrf(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences(SETTINGS_NAME,MODE_PRIVATE)
    }

    @Provides
    fun provideUserSettings(userSettingsImpl: UserSettingsImpl,sharedPreferences: SharedPreferences):UserSettings{
        return UserSettingsImpl(sharedPreferences)
    }

    @Provides
    fun provideUserSettingsRepository(userSettings: UserSettings):UserSettingsRepository{
        return UserSettingsRepositoryImpl(userSettings)
    }


}