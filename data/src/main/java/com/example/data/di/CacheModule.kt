package com.example.data.di

import com.example.data.cloud.abstraction.ImageManager
import com.example.data.realization.ImageManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class CacheModule {


    @Provides
    fun provideImageSaver(imageSaverImpl: ImageManagerImpl):ImageManager{
        return imageSaverImpl
    }
}