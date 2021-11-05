package com.example.data.cloud.api

import com.example.data.core.Constants
import com.example.domain.models.ImageCloudModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageApiService {

    @GET("api")
    suspend fun fetchImages(
        @Query("key") key:String = Constants.ACCESS_KEY,
        @Query("per_page") perPage:Int = Constants.PAGE_SIZE,
        @Query("page") page:Int,
        @Query("q") query:String = "dog"
    ):ImageCloudModel

}