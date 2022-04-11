package com.cbaassignment.feature.newsList

import com.cbaassignment.domain.NewsListItem

sealed class NewsListViewModelEvent  {
    data class ShowNewsDetails(val item: NewsListItem) : NewsListViewModelEvent()
}