// Generated by Dagger (https://dagger.dev).
package com.example.data.cloud.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ImagePagingSource_Factory implements Factory<ImagePagingSource> {
  private final Provider<ImageApiService> imageApiServiceProvider;

  public ImagePagingSource_Factory(Provider<ImageApiService> imageApiServiceProvider) {
    this.imageApiServiceProvider = imageApiServiceProvider;
  }

  @Override
  public ImagePagingSource get() {
    return newInstance(imageApiServiceProvider.get());
  }

  public static ImagePagingSource_Factory create(
      Provider<ImageApiService> imageApiServiceProvider) {
    return new ImagePagingSource_Factory(imageApiServiceProvider);
  }

  public static ImagePagingSource newInstance(ImageApiService imageApiService) {
    return new ImagePagingSource(imageApiService);
  }
}
