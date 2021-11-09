package com.example.exampletaxi.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/exampletaxi/adapters/ImagesPagingAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/example/exampletaxi/core/ImageUiModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callBack", "Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$CallBack;", "isSafeMode", "", "(Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$CallBack;Z)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CallBack", "Comparator", "ImageViewHolder", "app_debug"})
public final class ImagesPagingAdapter extends androidx.paging.PagingDataAdapter<com.example.exampletaxi.core.ImageUiModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final com.example.exampletaxi.adapters.ImagesPagingAdapter.CallBack callBack = null;
    private final boolean isSafeMode = false;
    
    public ImagesPagingAdapter(@org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.adapters.ImagesPagingAdapter.CallBack callBack, boolean isSafeMode) {
        super(null, null, null);
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/exampletaxi/databinding/ImageItemBinding;", "(Lcom/example/exampletaxi/adapters/ImagesPagingAdapter;Lcom/example/exampletaxi/databinding/ImageItemBinding;)V", "onBind", "", "imageUiModel", "Lcom/example/exampletaxi/core/ImageUiModel;", "app_debug"})
    public final class ImageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.exampletaxi.databinding.ImageItemBinding binding = null;
        
        public ImageViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.databinding.ImageItemBinding binding) {
            super(null);
        }
        
        public final void onBind(@org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel imageUiModel) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$Comparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/exampletaxi/core/ImageUiModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class Comparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.exampletaxi.core.ImageUiModel> {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.exampletaxi.adapters.ImagesPagingAdapter.Comparator INSTANCE = null;
        
        private Comparator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel oldItem, @org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel oldItem, @org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$CallBack;", "", "onClickOpenImage", "", "uiModel", "Lcom/example/exampletaxi/core/ImageUiModel;", "imageView", "Landroid/widget/ImageView;", "app_debug"})
    public static abstract interface CallBack {
        
        public abstract void onClickOpenImage(@org.jetbrains.annotations.NotNull()
        com.example.exampletaxi.core.ImageUiModel uiModel, @org.jetbrains.annotations.NotNull()
        android.widget.ImageView imageView);
    }
}