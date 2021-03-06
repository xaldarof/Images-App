package com.uz.data.di

import android.content.Context
import com.uz.data.cache.ImageDao
import com.uz.data.cloud.abstraction.ImageDataSource
import com.uz.data.cloud.api.ImageApiService
import com.uz.data.utils.Constants
import com.uz.data.realization.DataRepositoryImpl
import com.uz.data.realization.ImageDataSourceImpl
import com.uz.domain.abstraction.DataRepository
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CloudModule {


    @Provides
    fun provideDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository {
        return dataRepositoryImpl
    }

    @Provides
    fun provideImageDataSource(service: ImageApiService,dao: ImageDao): ImageDataSource {
        return ImageDataSourceImpl(service,dao)
    }


    @Singleton
    @Provides
    fun provideImageService(retrofit: Retrofit): ImageApiService =
        retrofit.create(ImageApiService::class.java)


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofitClient(@ApplicationContext context: Context):OkHttpClient {
        return OkHttpClient.Builder()
            .build()

            //.addInterceptor(ChuckInterceptor(context))

    }
}

