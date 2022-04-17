package com.cbaassignment.feature.newsList

import android.util.Log
import androidx.lifecycle.*
import com.cbaassignment.domain.NewsListItem
import com.cbaassignment.service.NewsRepository
import com.cbaassignment.service.Repository
import com.cbaassignment.utils.OpenForTesting
import com.cbaassignment.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@OpenForTesting
@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val news: MutableLiveData<List<NewsListItem>> = MutableLiveData()
    private val event: SingleLiveEvent<NewsListViewModelEvent> = SingleLiveEvent()
    val getNews: LiveData<List<NewsListItem>> get() = news
    val getEvent get() = event
    val adapter = NewsListAdapter(this)

    fun fetchNews() {
        viewModelScope.launch {
            val res = repository.getNews()
            if (res.isSuccessful) {
                Log.i("Tag", res.body()?.toString()?:"")
                news.postValue(res.body()?.articles)
            }
        }
    }

    fun submitNewsData(news: List<NewsListItem>?) {
        adapter.submitList(news)
    }

    fun onClickNewsItem(item: NewsListItem) {
        event.postValue(NewsListViewModelEvent.ShowNewsDetails(item))
    }
}