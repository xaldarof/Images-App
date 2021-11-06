package com.example.data.realization;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/data/realization/ImageDataSourceImpl;", "Lcom/example/data/cloud/abstraction/ImageDataSource;", "apiService", "Lcom/example/data/cloud/api/ImageApiService;", "(Lcom/example/data/cloud/api/ImageApiService;)V", "fetchImages", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/domain/models/ImageDomainModel;", "query", "", "data_debug"})
public final class ImageDataSourceImpl implements com.example.data.cloud.abstraction.ImageDataSource {
    private final com.example.data.cloud.api.ImageApiService apiService = null;
    
    @javax.inject.Inject()
    public ImageDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.cloud.api.ImageApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.models.ImageDomainModel>> fetchImages(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}