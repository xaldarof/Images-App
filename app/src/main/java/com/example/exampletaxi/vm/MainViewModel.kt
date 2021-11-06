package com.example.exampletaxi.vm

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.DataRepository
import com.example.domain.models.ImageDomainModel
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.mappers.ImageMapper
import com.example.exampletaxi.mappers.ImageMapperImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel

@Inject constructor(private val repository: DataRepository,
                    private val mapper: ImageMapperImpl): ViewModel() {

    fun fetchImages(query:String): Flow<PagingData<ImageUiModel>> {
       return repository.fetchImages(query).map { it ->
           it.map {
                mapper.mapToUi(it)
            }
        }
    }

    suspend fun saveImage(imageView: ImageView){
        repository.saveImage(imageView)
    }

    suspend fun shareImage(imageView: ImageView){
        repository.shareImage(imageView)
    }
}