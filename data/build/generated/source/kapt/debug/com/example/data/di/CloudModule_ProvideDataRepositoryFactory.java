// Generated by Dagger (https://dagger.dev).
package com.example.data.di;

import com.example.data.realization.DataRepositoryImpl;
import com.example.domain.abstraction.DataRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CloudModule_ProvideDataRepositoryFactory implements Factory<DataRepository> {
  private final Provider<DataRepositoryImpl> dataRepositoryImplProvider;

  public CloudModule_ProvideDataRepositoryFactory(
      Provider<DataRepositoryImpl> dataRepositoryImplProvider) {
    this.dataRepositoryImplProvider = dataRepositoryImplProvider;
  }

  @Override
  public DataRepository get() {
    return provideDataRepository(dataRepositoryImplProvider.get());
  }

  public static CloudModule_ProvideDataRepositoryFactory create(
      Provider<DataRepositoryImpl> dataRepositoryImplProvider) {
    return new CloudModule_ProvideDataRepositoryFactory(dataRepositoryImplProvider);
  }

  public static DataRepository provideDataRepository(DataRepositoryImpl dataRepositoryImpl) {
    return Preconditions.checkNotNullFromProvides(CloudModule.INSTANCE.provideDataRepository(dataRepositoryImpl));
  }
}
