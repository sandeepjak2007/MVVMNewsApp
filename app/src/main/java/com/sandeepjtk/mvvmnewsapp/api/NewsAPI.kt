package com.sandeepjtk.mvvmnewsapp.api

import com.sandeepjtk.mvvmnewsapp.model.NewsResponse
import com.sandeepjtk.mvvmnewsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        country: String = "in",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = Constants.API_KEY
    ) : Response<NewsResponse>
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchVale: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = Constants.API_KEY
    ):Response<NewsResponse>
}