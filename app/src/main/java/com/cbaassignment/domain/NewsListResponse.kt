package com.cbaassignment.domain

data class NewsListResponse(
    val status: String,
    val articles: List<NewsListItem>
)