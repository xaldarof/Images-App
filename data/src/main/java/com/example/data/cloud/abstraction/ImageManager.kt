package com.example.data.cloud.abstraction

import android.widget.ImageView

interface ImageManager {
    suspend fun saveImage(imageView: ImageView): String
    fun shareImage(path: String)
}