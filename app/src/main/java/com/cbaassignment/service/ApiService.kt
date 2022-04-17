package com.cbaassignment.service

import com.cbaassignment.domain.NewsListItem
import com.cbaassignment.domain.NewsListResponse
import com.cbaassignment.utils.OpenForTesting
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

@OpenForTesting
interface ApiService {
    @GET("top-headlines/category/health/in.json")
    suspend fun getNews(): Response<NewsListResponse>
}