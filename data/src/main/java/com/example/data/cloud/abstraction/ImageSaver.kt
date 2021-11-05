package com.example.data.cloud.abstraction

import android.widget.ImageView

interface ImageSaver {
    suspend fun saveImage(imageView: ImageView): String
}