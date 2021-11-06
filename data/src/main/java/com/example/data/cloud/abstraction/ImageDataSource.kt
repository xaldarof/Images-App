package com.example.data.cloud.abstraction

import androidx.paging.PagingData
import com.example.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow

interface ImageDataSource {

    fun fetchImages(query:String):Flow<PagingData<ImageDomainModel>>

}