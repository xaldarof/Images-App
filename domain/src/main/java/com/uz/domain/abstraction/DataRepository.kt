package com.uz.domain.abstraction

import android.widget.ImageView
import androidx.paging.PagingData
import com.uz.domain.models.ImageDbModel
import com.uz.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow


interface DataRepository {

    fun fetchImages(query: String): Flow<PagingData<ImageDomainModel>>

    suspend fun saveImage(imageView: ImageView)

    suspend fun shareImage(imageView: ImageView)

    suspend fun setWallpaper(imageView: ImageView)

    suspend fun fetchCacheImagesAsFlow():Flow<List<ImageDbModel>>
    fun fetchCacheImages():List<ImageDbModel>

    suspend fun saveCacheImage(imageDbModel: ImageDbModel)

    fun removeCacheImage(id:Int)
}