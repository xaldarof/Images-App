package com.example.data.realization;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/data/realization/DataRepositoryImpl;", "Lcom/example/domain/DataRepository;", "imageDataSource", "Lcom/example/data/cloud/abstraction/ImageDataSource;", "imageSaver", "Lcom/example/data/cloud/abstraction/ImageSaver;", "(Lcom/example/data/cloud/abstraction/ImageDataSource;Lcom/example/data/cloud/abstraction/ImageSaver;)V", "fetchImages", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/domain/models/ImageDomainModel;", "saveImage", "", "imageView", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class DataRepositoryImpl implements com.example.domain.DataRepository {
    private final com.example.data.cloud.abstraction.ImageDataSource imageDataSource = null;
    private final com.example.data.cloud.abstraction.ImageSaver imageSaver = null;
    
    @javax.inject.Inject()
    public DataRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.cloud.abstraction.ImageDataSource imageDataSource, @org.jetbrains.annotations.NotNull()
    com.example.data.cloud.abstraction.ImageSaver imageSaver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.models.ImageDomainModel>> fetchImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
}