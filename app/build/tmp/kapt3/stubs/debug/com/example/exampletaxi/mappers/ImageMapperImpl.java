package com.example.exampletaxi.mappers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006\f"}, d2 = {"Lcom/example/exampletaxi/mappers/ImageMapperImpl;", "Lcom/example/exampletaxi/mappers/ImageMapper;", "Lcom/example/domain/models/ImageDomainModel;", "Lcom/example/exampletaxi/core/ImageUiModel;", "()V", "mapToDb", "Lcom/example/domain/models/ImageDbModel;", "imageUiModel", "mapToUi", "data", "", "list", "app_debug"})
public final class ImageMapperImpl implements com.example.exampletaxi.mappers.ImageMapper<com.example.domain.models.ImageDomainModel, com.example.exampletaxi.core.ImageUiModel> {
    
    @javax.inject.Inject()
    public ImageMapperImpl() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.exampletaxi.core.ImageUiModel mapToUi(@org.jetbrains.annotations.NotNull()
    com.example.domain.models.ImageDomainModel data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.domain.models.ImageDbModel mapToDb(@org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.core.ImageUiModel imageUiModel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.exampletaxi.core.ImageUiModel> mapToUi(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.domain.models.ImageDbModel> list) {
        return null;
    }
}