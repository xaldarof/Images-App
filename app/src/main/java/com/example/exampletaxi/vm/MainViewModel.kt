package com.example.exampletaxi.vm

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.BaseViewModel
import com.example.domain.abstraction.DataRepository
import com.example.domain.abstraction.UserSettingsRepository
import com.example.domain.models.ImageDbModel
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.mappers.ImageMapperImpl
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

    suspend fun fetchCacheImagesAsFlow() : Flow<List<ImageDbModel>> {
        return repository.fetchCacheImagesAsFlow()
    }

    fun fetchCacheImages() : List<ImageUiModel> {
        return mapper.mapToUi(repository.fetchCacheImages())
    }

    fun removeCacheImage(model: ImageDbModel){
        repository.removeCacheImage(model.id)
    }

    suspend fun saveCacheImage(uiModel: ImageUiModel) = repository.saveCacheImage(mapper.mapToDb(uiModel))

    fun setUserRecommends(name:String) = userSettingsRepository.setUserRecommends(name)
    fun fetchUserRecommends():String? = userSettingsRepository.fetchUserRecommends()

}