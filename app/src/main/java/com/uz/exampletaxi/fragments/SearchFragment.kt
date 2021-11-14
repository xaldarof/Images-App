package com.uz.exampletaxi.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.uz.core.BaseFragment
import com.uz.exampletaxi.R
import com.uz.exampletaxi.adapters.HeaderFooterAdapter
import com.uz.exampletaxi.adapters.ImagesPagingAdapter
import com.uz.exampletaxi.core.ImageUiModel
import com.uz.exampletaxi.databinding.FragmentSearchBinding
import com.uz.exampletaxi.dialogs.ShowImageDialog
import com.uz.exampletaxi.utils.CallBack
import com.uz.exampletaxi.utils.CustomTextChangedListener
import com.uz.exampletaxi.utils.UiConstants.DEFAULT
import com.uz.exampletaxi.utils.UiConstants.NOTHING
import com.uz.exampletaxi.utils.openBrowser
import com.uz.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment(),ImagesPagingAdapter.CallBack,ShowImageDialog.CallBack {

    private lateinit var binding:FragmentSearchBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ImagesPagingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ImagesPagingAdapter(this,viewModel.isSafeMode())

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
                    if (p0.toString().length > 2) {
                        viewModel.fetchImages(if (p0.toString().isEmpty()) NOTHING else p0.toString())
                            .collectLatest {
                                adapter.submitData(it)
                            }
                    }
                }
            }
        }))
    }

    override fun onClickOpenImage(uiModel: ImageUiModel, imageView: ImageView) {
        ShowImageDialog(this,uiModel).show(parentFragmentManager,DEFAULT)
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
            toast(R.string.success_add)
        }
    }

    override fun onClickSetWallpaper(imageView: ImageView) {
        lifecycleScope.launch {
            viewModel.setWallpaper(imageView)
        }
    }
}