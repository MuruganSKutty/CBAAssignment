package com.cbaassignment.service

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getNewsList() = apiService.getNews()
}