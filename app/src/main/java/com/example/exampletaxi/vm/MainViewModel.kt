package com.example.exampletaxi.vm

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.DataRepository
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

    fun fetchImages(): Flow<PagingData<ImageUiModel>> {
       return repository.fetchImages().map {
            it.map {
                mapper.mapToUi(it)
            }
        }
    }
}