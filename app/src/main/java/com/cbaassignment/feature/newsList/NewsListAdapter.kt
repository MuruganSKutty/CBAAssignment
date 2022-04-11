package com.cbaassignment.feature.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.cbaassignment.databinding.ViewNewsListItemBinding
import com.cbaassignment.domain.NewsListItem

class NewsListAdapter(val viewModel: NewsListViewModel) : ListAdapter<NewsListItem, NewsItemViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding = ViewNewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<NewsListItem>() {
    override fun areItemsTheSame(oldItem: NewsListItem, newItem: NewsListItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsListItem, newItem: NewsListItem): Boolean {
        return oldItem == newItem
    }

}