package com.example.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorites")
data class ImageDbModel(
    val comments: Int,
    val downloads: Int,
    @PrimaryKey
    val id: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewURL: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val views: Int,
    val webFormat:String,
)