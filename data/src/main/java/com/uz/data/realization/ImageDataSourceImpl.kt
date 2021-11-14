package com.uz.data.realization

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.uz.data.cache.ImageDao
import com.uz.data.cloud.abstraction.ImageDataSource
import com.uz.data.cloud.api.ImageApiService
import com.uz.data.cloud.api.ImagePagingSource
import com.uz.data.utils.Constants
import com.uz.domain.models.ImageDbModel
import com.uz.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageDataSourceImpl

@Inject constructor(private val apiService: ImageApiService,
                    private val dao: ImageDao): ImageDataSource {


    override fun fetchImages(query:String): Flow<PagingData<ImageDomainModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagePagingSource(apiService,query)
            }
        ).flow
    }

    override fun fetchCacheImages(): List<ImageDbModel> {
        return dao.fetchCacheImages()
    }

    override suspend fun fetchCacheImagesAsFlow(): Flow<List<ImageDbModel>> {
        return dao.fetchCacheImagesAsFlow()
    }
    override suspend fun saveCacheImage(imageDbModel: ImageDbModel) {
        dao.saveCacheImage(imageDbModel)
    }

    override fun removeCacheImage(id:Int) {
        dao.removeCacheImage(id)
    }
}