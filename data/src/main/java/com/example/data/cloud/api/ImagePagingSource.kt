package com.example.data.cloud.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.models.ImageDomainModel
import javax.inject.Inject


class ImagePagingSource

@Inject constructor(private val imageApiService: ImageApiService,private val query:String): PagingSource<Int,ImageDomainModel>() {


    override fun getRefreshKey(state: PagingState<Int, ImageDomainModel>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageDomainModel> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = imageApiService.fetchImages(page = nextPageNumber,query = query)
            val data = response.imageDomainModel
            val nextKey = if (data.isEmpty()) null else nextPageNumber + 1

            LoadResult.Page(data = data,prevKey = if (nextPageNumber == 1)
                null else nextPageNumber,nextKey = nextKey)

        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}