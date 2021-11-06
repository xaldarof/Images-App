package com.example.data.realization

import android.widget.ImageView
import androidx.paging.PagingData
import com.example.data.cloud.abstraction.ImageDataSource
import com.example.data.cloud.abstraction.ImageManager
import com.example.domain.models.ImageDomainModel
import com.example.domain.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl

@Inject constructor(private val imageDataSource: ImageDataSource,
                    private val imageManager: ImageManager): DataRepository {

    override fun fetchImages(): Flow<PagingData<ImageDomainModel>> {
        return imageDataSource.fetchImages()
    }

    override suspend fun saveImage(imageView: ImageView):String{
       return imageManager.saveImage(imageView)
    }
}