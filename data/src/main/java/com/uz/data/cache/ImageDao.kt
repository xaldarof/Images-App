package com.uz.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.uz.domain.models.ImageDbModel
import kotlinx.coroutines.flow.Flow


@Dao
interface ImageDao {

    @Query("SELECT * FROM favorites")
    fun fetchCacheImagesAsFlow():Flow<List<ImageDbModel>>

    @Query("SELECT * FROM favorites")
    fun fetchCacheImages():List<ImageDbModel>

    @Query("DELETE FROM favorites WHERE id=:id")
    fun removeCacheImage(id:Int)

    @Insert
    suspend fun saveCacheImage(imageDbModel: ImageDbModel)

}