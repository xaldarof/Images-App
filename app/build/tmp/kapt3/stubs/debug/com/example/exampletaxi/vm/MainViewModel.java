package com.example.exampletaxi.vm;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0019\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/exampletaxi/vm/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/domain/DataRepository;", "mapper", "Lcom/example/exampletaxi/mappers/ImageMapperImpl;", "(Lcom/example/domain/DataRepository;Lcom/example/exampletaxi/mappers/ImageMapperImpl;)V", "fetchCacheImages", "", "Lcom/example/exampletaxi/core/ImageUiModel;", "fetchCacheImagesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/domain/models/ImageDbModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchImages", "Landroidx/paging/PagingData;", "query", "", "removeCacheImage", "", "model", "saveCacheImage", "uiModel", "(Lcom/example/exampletaxi/core/ImageUiModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveImage", "imageView", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareImage", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.DataRepository repository = null;
    private final com.example.exampletaxi.mappers.ImageMapperImpl mapper = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.DataRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.mappers.ImageMapperImpl mapper) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveCacheImage(@org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.core.ImageUiModel uiModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}