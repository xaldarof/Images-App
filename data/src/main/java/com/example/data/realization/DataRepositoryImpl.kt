package com.example.data.realization

import androidx.paging.PagingData
import com.example.data.cloud.abstraction.ImageDataSource
import com.example.domain.models.ImageDomainModel
import com.example.domain.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl

@Inject constructor(private val imageDataSource: ImageDataSource): DataRepository {

    override fun fetchImages(): Flow<PagingData<ImageDomainModel>> {
        return imageDataSource.fetchImages()
    }
}