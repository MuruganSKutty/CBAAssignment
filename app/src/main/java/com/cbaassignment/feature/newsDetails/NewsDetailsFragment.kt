package com.cbaassignment.feature.newsDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.cbaassignment.R
import com.cbaassignment.databinding.NewsDetailsFragmentBinding
import com.cbaassignment.databinding.NewsListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {

    private val viewModel by viewModels<NewsDetailsViewModel>()
    private var _binding: NewsDetailsFragmentBinding? = null
    private val binding: NewsDetailsFragmentBinding get() = _binding!!
    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.item = args.newsItem
        Glide.with(this)
            .load(args.newsItem.imageUrl)
            .error(R.drawable.placeholder_drawable)
            .into(binding.ivImage)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}