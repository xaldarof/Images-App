package com.example.domain

import androidx.paging.PagingData
import com.example.domain.models.ImageDomainModel
import kotlinx.coroutines.flow.Flow


interface DataRepository {

    fun fetchImages():Flow<PagingData<ImageDomainModel>>

}