package com.cbaassignment.feature.newsList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cbaassignment.R
import com.cbaassignment.databinding.NewsListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private val viewModel by viewModels<NewsListViewModel>()
    private var _binding: NewsListFragmentBinding? = null
    private val binding: NewsListFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.fetchNews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getNews.observe(viewLifecycleOwner, { news ->
            viewModel.submitNewsData(news)
        })
        viewModel.getEvent.observe(viewLifecycleOwner, {
            when(it) {
                is NewsListViewModelEvent.ShowNewsDetails -> {
                    findNavController().navigate(com.cbaassignment.feature.newsList.NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(
                        it.item
                    ))
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}