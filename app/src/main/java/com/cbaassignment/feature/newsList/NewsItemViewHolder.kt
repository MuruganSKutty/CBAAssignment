package com.cbaassignment.feature.newsList

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cbaassignment.R
import com.cbaassignment.databinding.ViewNewsListItemBinding
import com.cbaassignment.domain.NewsListItem

class NewsItemViewHolder(private val binding: ViewNewsListItemBinding,val viewModel: NewsListViewModel) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NewsListItem) {
        binding.item = item
        binding.viewModel = viewModel
        Glide.with(itemView.context)
            .load(item.imageUrl)
            .error(R.drawable.placeholder_drawable)
            .into(binding.ivImage)
        itemView.setOnClickListener {
            viewModel.onClickNewsItem(item)
        }
    }
}