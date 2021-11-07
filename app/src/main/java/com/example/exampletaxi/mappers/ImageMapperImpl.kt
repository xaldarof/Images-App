package com.example.exampletaxi.mappers

import com.example.domain.models.ImageDomainModel
import com.example.exampletaxi.core.ImageUiModel
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
}