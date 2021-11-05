// Generated by Dagger (https://dagger.dev).
package com.example.data.realization;

import com.example.data.cloud.api.ImageApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ImageDataSourceImpl_Factory implements Factory<ImageDataSourceImpl> {
  private final Provider<ImageApiService> apiServiceProvider;

  public ImageDataSourceImpl_Factory(Provider<ImageApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ImageDataSourceImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static ImageDataSourceImpl_Factory create(Provider<ImageApiService> apiServiceProvider) {
    return new ImageDataSourceImpl_Factory(apiServiceProvider);
  }

  public static ImageDataSourceImpl newInstance(ImageApiService apiService) {
    return new ImageDataSourceImpl(apiService);
  }
}
