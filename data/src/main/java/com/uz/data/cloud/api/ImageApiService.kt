package com.uz.data.cloud.api

import com.uz.data.utils.Constants
import com.uz.domain.models.ImageCloudModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageApiService {

    @GET("api")
    suspend fun fetchImages(
        @Query("key") key:String = Constants.ACCESS_KEY,
        @Query("per_page") perPage:Int = Constants.PAGE_SIZE,
        @Query("page") page:Int,
        @Query("q") query:String
    ):ImageCloudModel

}