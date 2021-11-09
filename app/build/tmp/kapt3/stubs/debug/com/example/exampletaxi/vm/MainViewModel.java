package com.example.exampletaxi.vm;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\r2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u0019\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0013J\u0019\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010&\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/exampletaxi/vm/MainViewModel;", "Lcom/example/core/BaseViewModel;", "repository", "Lcom/example/domain/abstraction/DataRepository;", "mapper", "Lcom/example/exampletaxi/mappers/ImageMapperImpl;", "userSettingsRepository", "Lcom/example/domain/abstraction/UserSettingsRepository;", "(Lcom/example/domain/abstraction/DataRepository;Lcom/example/exampletaxi/mappers/ImageMapperImpl;Lcom/example/domain/abstraction/UserSettingsRepository;)V", "fetchCacheImages", "", "Lcom/example/exampletaxi/core/ImageUiModel;", "fetchCacheImagesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/domain/models/ImageDbModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchImages", "Landroidx/paging/PagingData;", "query", "", "fetchUserRecommends", "isSafeMode", "", "removeCacheImage", "", "model", "saveCacheImage", "uiModel", "(Lcom/example/exampletaxi/core/ImageUiModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveImage", "imageView", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSafeModel", "mode", "setUserRecommends", "name", "setWallpaper", "shareImage", "app_debug"})
public final class MainViewModel extends com.example.core.BaseViewModel {
    private final com.example.domain.abstraction.DataRepository repository = null;
    private final com.example.exampletaxi.mappers.ImageMapperImpl mapper = null;
    private final com.example.domain.abstraction.UserSettingsRepository userSettingsRepository = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.abstraction.DataRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.mappers.ImageMapperImpl mapper, @org.jetbrains.annotations.NotNull()
    com.example.domain.abstraction.UserSettingsRepository userSettingsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.exampletaxi.core.ImageUiModel>> fetchImages(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object shareImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setWallpaper(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchCacheImagesAsFlow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.domain.models.ImageDbModel>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.exampletaxi.core.ImageUiModel> fetchCacheImages() {
        return null;
    }
    
    public final void removeCacheImage(@org.jetbrains.annotations.NotNull()
    com.example.domain.models.ImageDbModel model) {
    }
    
    public final void setSafeModel(boolean mode) {
    }
    
    public final boolean isSafeMode() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveCacheImage(@org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.core.ImageUiModel uiModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void setUserRecommends(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fetchUserRecommends() {
        return null;
    }
}