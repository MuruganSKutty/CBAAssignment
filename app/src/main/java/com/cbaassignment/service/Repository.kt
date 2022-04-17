package com.cbaassignment.service

import com.cbaassignment.domain.NewsListResponse
import com.cbaassignment.utils.OpenForTesting
import retrofit2.Response
import javax.inject.Inject

@OpenForTesting
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : NewsRepository {
    override suspend fun getNews(): Response<NewsListResponse> {
        return remoteDataSource.getNewsList()
    }
}