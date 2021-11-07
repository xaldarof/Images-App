package com.example.exampletaxi.mappers

import com.example.domain.models.ImageDbModel
import com.example.domain.models.ImageDomainModel
import com.example.exampletaxi.core.ImageUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ImageMapperImpl @Inject constructor() : ImageMapper<ImageDomainModel, ImageUiModel> {

    override fun mapToUi(data: ImageDomainModel): ImageUiModel {
        return ImageUiModel(
            data.comments,
            data.downloads,
            data.id,
            data.largeImageURL,
            data.likes,
            data.pageURL,
            data.previewURL,
            data.user,
            data.userImageURL,
            data.user_id,
            data.views,
            data.webformatURL,
        )
    }

    fun mapToDb(imageUiModel: ImageUiModel): ImageDbModel {
        return ImageDbModel(
            imageUiModel.comments,
            imageUiModel.downloads,
            imageUiModel.id,
            imageUiModel.largeImageURL,
            imageUiModel.likes,
            imageUiModel.pageURL,
            imageUiModel.previewURL,
            imageUiModel.user,
            imageUiModel.userImageURL,
            imageUiModel.user_id,
            imageUiModel.views,
            imageUiModel.webFormat,
        )
    }

    fun mapToUi(list: List<ImageDbModel>): List<ImageUiModel> {
        val newList = ArrayList<ImageUiModel>()
        list.forEach { it ->
            newList.add(ImageUiModel(
                it.comments,
                it.downloads,
                it.id,
                it.largeImageURL,
                it.likes,
                it.pageURL,
                it.previewURL,
                it.user,
                it.userImageURL,
                it.user_id,
                it.views,
                it.webFormat
            ))
        }
        return newList
    }
}