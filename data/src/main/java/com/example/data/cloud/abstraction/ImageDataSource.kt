package com.example.data.cloud.abstraction

import androidx.paging.PagingData
import com.example.domain.models.ImageDbModel
import com.example.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow

interface ImageDataSource {

    fun fetchImages(query:String):Flow<PagingData<ImageDomainModel>>

    suspend fun fetchCacheImagesAsFlow():Flow<List<ImageDbModel>>
    fun fetchCacheImages():List<ImageDbModel>

    suspend fun saveCacheImage(imageDbModel: ImageDbModel)

    fun removeCacheImage(id:Int)

}