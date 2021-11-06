package com.example.exampletaxi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exampletaxi.adapters.HeaderFooterAdapter
import com.example.exampletaxi.adapters.ImagesPagingAdapter
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentHomeBinding
import com.example.exampletaxi.dialogs.ShowImageDialog
import com.example.exampletaxi.utils.openBrowser
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), ImagesPagingAdapter.CallBack,ShowImageDialog.CallBack {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ImagesPagingAdapter(this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateFooter(footer = HeaderFooterAdapter { adapter.retry() })

        lifecycleScope.launch {
            viewModel.fetchImages("").collectLatest {
                adapter.submitData(it)
            }
        }

        adapter.addLoadStateListener {
            binding.errorIcon.isVisible = it.refresh is LoadState.Error
            binding.progressView.isVisible = it.refresh is LoadState.Loading
        }
    }


    override fun onClickOpenImage(uiModel: ImageUiModel, imageView: ImageView) {
        ShowImageDialog(requireContext(),uiModel).showDialog(this)
    }

    override fun onShare(imageView: ImageView) {
        lifecycleScope.launch {
            viewModel.shareImage(imageView)
        }
    }

    override fun onSave(imageView: ImageView) {
        lifecycleScope.launch {
            viewModel.saveImage(imageView)
        }
    }

    override fun onOpenBrowser(uiModel: ImageUiModel) {
        requireContext().openBrowser(uiModel.pageURL)
    }
}