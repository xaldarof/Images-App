package com.example.exampletaxi.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exampletaxi.R
import com.example.exampletaxi.adapters.HeaderFooterAdapter
import com.example.exampletaxi.adapters.ImagesPagingAdapter
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentSearchBinding
import com.example.exampletaxi.dialogs.ShowImageDialog
import com.example.exampletaxi.utils.CallBack
import com.example.exampletaxi.utils.CustomTextChangedListener
import com.example.exampletaxi.utils.UiConstants.EMPTY
import com.example.exampletaxi.utils.UiConstants.NOTHING
import com.example.exampletaxi.utils.openBrowser
import com.example.exampletaxi.utils.showIfEmpty
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(),ImagesPagingAdapter.CallBack,ShowImageDialog.CallBack {

    private lateinit var binding:FragmentSearchBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ImagesPagingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ImagesPagingAdapter(this)

        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateFooter(footer = HeaderFooterAdapter{adapter.retry()})

        adapter.addLoadStateListener {
            binding.errorContainer.isVisible = it.refresh is LoadState.Error
            binding.progressView.isVisible = it.refresh is LoadState.Loading
            binding.rv.isVisible = it.refresh !is LoadState.Error
        }

        binding.retryBtn.setOnClickListener {
            adapter.retry()
        }

        binding.searchView.addTextChangedListener(CustomTextChangedListener(object :CallBack{
            override fun afterChanged(p0: Editable?) {
                lifecycleScope.launch {
                    viewModel.fetchImages(if (p0.toString().isEmpty())NOTHING else p0.toString())
                        .distinctUntilChanged()
                        .collectLatest {
                            adapter.submitData(it)
                        }
                }
            }
        }))
    }

    override fun onClickOpenImage(uiModel: ImageUiModel, imageView: ImageView) {
        ShowImageDialog(this,uiModel).show(parentFragmentManager,EMPTY)
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
        requireContext().openBrowser(uiModel.webFormat)
    }

    override fun onOpenUserPage(uiModel: ImageUiModel) {
        requireContext().openBrowser(uiModel.pageURL)
    }

    override fun onClickRetry() {
        adapter.retry()
    }

    override fun onClickAddFavorites(uiModel: ImageUiModel) {
        lifecycleScope.launch {
            viewModel.saveCacheImage(uiModel)
            Toast.makeText(requireContext(), R.string.success_add , Toast.LENGTH_SHORT).show()
        }
    }
}