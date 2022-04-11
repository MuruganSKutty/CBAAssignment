package com.cbaassignment.service

import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getNews() = remoteDataSource.getNewsList()
}