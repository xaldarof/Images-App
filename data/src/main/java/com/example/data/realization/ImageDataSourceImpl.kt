package com.example.data.realization

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.cloud.abstraction.ImageDataSource
import com.example.data.cloud.api.ImageApiService
import com.example.data.cloud.api.ImagePagingSource
import com.example.data.core.Constants
import com.example.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageDataSourceImpl

@Inject constructor(private val apiService: ImageApiService): ImageDataSource {


    override fun fetchImages(): Flow<PagingData<ImageDomainModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagePagingSource(apiService)
            }
        ).flow
    }
}