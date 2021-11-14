package com.uz.domain.models

import com.google.gson.annotations.SerializedName

data class ImageCloudModel(
    @SerializedName("hits")
    val imageDomainModel: List<ImageDomainModel>,
    val total: Int,
    val totalHits: Int
)