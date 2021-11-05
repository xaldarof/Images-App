package com.example.exampletaxi.mappers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exampletaxi/mappers/ImageMapper;", "ImageDomain", "ImageUi", "", "mapToUi", "data", "(Ljava/lang/Object;)Ljava/lang/Object;", "app_debug"})
public abstract interface ImageMapper<ImageDomain extends java.lang.Object, ImageUi extends java.lang.Object> {
    
    public abstract ImageUi mapToUi(ImageDomain data);
}