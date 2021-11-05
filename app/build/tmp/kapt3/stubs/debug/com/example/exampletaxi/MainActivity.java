package com.example.exampletaxi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/example/exampletaxi/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/exampletaxi/adapters/ImagesPagingAdapter$CallBack;", "()V", "binding", "Lcom/example/exampletaxi/databinding/ActivityMainBinding;", "viewModel", "Lcom/example/exampletaxi/vm/MainViewModel;", "getViewModel", "()Lcom/example/exampletaxi/vm/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onClickOptions", "", "uiModel", "Lcom/example/exampletaxi/core/ImageUiModel;", "view", "Landroid/view/View;", "image", "Landroid/widget/ImageView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.exampletaxi.adapters.ImagesPagingAdapter.CallBack {
    private com.example.exampletaxi.databinding.ActivityMainBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.exampletaxi.vm.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClickOptions(@org.jetbrains.annotations.NotNull()
    com.example.exampletaxi.core.ImageUiModel uiModel, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView image) {
    }
}