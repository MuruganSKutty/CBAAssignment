package com.cbaassignment.service

import com.cbaassignment.utils.OpenForTesting
import javax.inject.Inject

@OpenForTesting
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getNewsList() = apiService.getNews()
}