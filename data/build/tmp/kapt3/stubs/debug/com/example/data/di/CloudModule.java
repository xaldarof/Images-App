package com.example.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/example/data/di/CloudModule;", "", "()V", "provideDataRepository", "Lcom/example/domain/DataRepository;", "dataRepositoryImpl", "Lcom/example/data/realization/DataRepositoryImpl;", "provideImageDataSource", "Lcom/example/data/cloud/abstraction/ImageDataSource;", "service", "Lcom/example/data/cloud/api/ImageApiService;", "dao", "Lcom/example/data/cache/ImageDao;", "provideImageService", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideRetrofitClient", "context", "Landroid/content/Context;", "data_debug"})
@dagger.Module()
public final class CloudModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.di.CloudModule INSTANCE = null;
    
    private CloudModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.domain.DataRepository provideDataRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.realization.DataRepositoryImpl dataRepositoryImpl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.cloud.abstraction.ImageDataSource provideImageDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.cloud.api.ImageApiService service, @org.jetbrains.annotations.NotNull()
    com.example.data.cache.ImageDao dao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.cloud.api.ImageApiService provideImageService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.OkHttpClient provideRetrofitClient(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
}