package com.cbaassignment.service

import com.cbaassignment.domain.NewsListResponse
import retrofit2.Response
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews() : Response<NewsListResponse>
}