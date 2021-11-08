// Generated by Dagger (https://dagger.dev).
package com.example.exampletaxi.vm;

import com.example.domain.abstraction.DataRepository;
import com.example.domain.abstraction.UserSettingsRepository;
import com.example.exampletaxi.mappers.ImageMapperImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<DataRepository> repositoryProvider;

  private final Provider<ImageMapperImpl> mapperProvider;

  private final Provider<UserSettingsRepository> userSettingsRepositoryProvider;

  public MainViewModel_Factory(Provider<DataRepository> repositoryProvider,
      Provider<ImageMapperImpl> mapperProvider,
      Provider<UserSettingsRepository> userSettingsRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.mapperProvider = mapperProvider;
    this.userSettingsRepositoryProvider = userSettingsRepositoryProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repositoryProvider.get(), mapperProvider.get(), userSettingsRepositoryProvider.get());
  }

  public static MainViewModel_Factory create(Provider<DataRepository> repositoryProvider,
      Provider<ImageMapperImpl> mapperProvider,
      Provider<UserSettingsRepository> userSettingsRepositoryProvider) {
    return new MainViewModel_Factory(repositoryProvider, mapperProvider, userSettingsRepositoryProvider);
  }

  public static MainViewModel newInstance(DataRepository repository, ImageMapperImpl mapper,
      UserSettingsRepository userSettingsRepository) {
    return new MainViewModel(repository, mapper, userSettingsRepository);
  }
}
