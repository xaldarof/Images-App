package com.example.domain

import android.widget.ImageView
import androidx.paging.PagingData
import com.example.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow


interface DataRepository {

    fun fetchImages():Flow<PagingData<ImageDomainModel>>

    suspend fun saveImage(imageView: ImageView):String

}