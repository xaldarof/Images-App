package com.example.data.di

import com.example.data.cloud.abstraction.ImageSaver
import com.example.data.realization.ImageSaverImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class CacheModule {


    @Provides
    fun provideImageSaver(imageSaverImpl: ImageSaverImpl):ImageSaver{
        return imageSaverImpl
    }
}