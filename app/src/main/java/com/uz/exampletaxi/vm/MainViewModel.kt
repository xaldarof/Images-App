package com.uz.exampletaxi.vm

import android.widget.ImageView
import androidx.paging.PagingData
import androidx.paging.map
import com.uz.core.BaseViewModel
import com.uz.domain.abstraction.DataRepository
import com.uz.domain.abstraction.UserSettingsRepository
import com.uz.domain.models.ImageDbModel
import com.uz.exampletaxi.core.ImageUiModel
import com.uz.exampletaxi.mappers.ImageMapperImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel

@Inject constructor(private val repository: DataRepository,
                    private val mapper: ImageMapperImpl,
                    private val userSettingsRepository: UserSettingsRepository): BaseViewModel() {

    fun fetchImages(query:String): Flow<PagingData<ImageUiModel>> {
       return repository.fetchImages(query).map { it ->
           it.map {
                mapper.mapToUi(it)
            }
        }
    }

    suspend fun saveImage(imageView: ImageView) {
        repository.saveImage(imageView)
    }

    suspend fun shareImage(imageView: ImageView){
        repository.shareImage(imageView)
    }

    suspend fun setWallpaper(imageView: ImageView){
        repository.setWallpaper(imageView)
    }

    suspend fun fetchCacheImagesAsFlow() : Flow<List<ImageDbModel>> {
        return repository.fetchCacheImagesAsFlow()
    }

    fun fetchCacheImages() : List<ImageUiModel> {
        return mapper.mapToUi(repository.fetchCacheImages())
    }

    fun removeCacheImage(model: ImageDbModel){
        repository.removeCacheImage(model.id)
    }

    fun setSafeModel(mode: Boolean) = userSettingsRepository.setSafeModel(mode)

    fun isSafeMode(): Boolean = userSettingsRepository.isSafeMode()

    suspend fun saveCacheImage(uiModel: ImageUiModel) = repository.saveCacheImage(mapper.mapToDb(uiModel))

    fun setUserRecommends(name:String) = userSettingsRepository.setUserRecommends(name)
    fun fetchUserRecommends():String? = userSettingsRepository.fetchUserRecommends()

}