package com.example.data.realization;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/data/realization/ImageDataSourceImpl;", "Lcom/example/data/cloud/abstraction/ImageDataSource;", "apiService", "Lcom/example/data/cloud/api/ImageApiService;", "dao", "Lcom/example/data/cache/ImageDao;", "(Lcom/example/data/cloud/api/ImageApiService;Lcom/example/data/cache/ImageDao;)V", "fetchCacheImages", "", "Lcom/example/domain/models/ImageDbModel;", "fetchCacheImagesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchImages", "Landroidx/paging/PagingData;", "Lcom/example/domain/models/ImageDomainModel;", "query", "", "removeCacheImage", "", "id", "", "saveCacheImage", "imageDbModel", "(Lcom/example/domain/models/ImageDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ImageDataSourceImpl implements com.example.data.cloud.abstraction.ImageDataSource {
    private final com.example.data.cloud.api.ImageApiService apiService = null;
    private final com.example.data.cache.ImageDao dao = null;
    
    @javax.inject.Inject()
    public ImageDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.cloud.api.ImageApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.data.cache.ImageDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.models.ImageDomainModel>> fetchImages(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.domain.models.ImageDbModel> fetchCacheImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object fetchCacheImagesAsFlow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.domain.models.ImageDbModel>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveCacheImage(@org.jetbrains.annotations.NotNull()
    com.example.domain.models.ImageDbModel imageDbModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public void removeCacheImage(int id) {
    }
}