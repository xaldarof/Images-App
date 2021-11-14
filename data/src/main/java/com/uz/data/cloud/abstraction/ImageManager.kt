package com.uz.data.cloud.abstraction

import android.widget.ImageView

interface ImageManager {
    suspend fun saveImage(imageView: ImageView)
    fun shareImage(imageView: ImageView)

    suspend fun setWallpaper(imageView: ImageView)
}