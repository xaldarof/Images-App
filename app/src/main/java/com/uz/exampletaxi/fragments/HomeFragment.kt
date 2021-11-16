package com.uz.exampletaxi.fragments

import android.os.Bundle
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
import com.uz.exampletaxi.databinding.FragmentHomeBinding
import com.uz.exampletaxi.dialogs.ShowImageDialog
import com.uz.exampletaxi.utils.UiConstants.chip_names
import com.uz.exampletaxi.utils.openBrowser
import com.uz.exampletaxi.vm.MainViewModel
import com.google.android.material.chip.Chip
import com.uz.exampletaxi.utils.addChips
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment(), ImagesPagingAdapter.CallBack,ShowImageDialog.CallBack {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ImagesPagingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.chipGroup.setOnCheckedChangeListener { _, _ ->
            for (i in 0 until binding.chipGroup.childCount) {
                val chip = binding.chipGroup.getChildAt(i) as Chip

                if (chip.isChecked) {
                    initData(chip.text.toString())
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(viewModel.fetchUserRecommends()!!)
        binding.chipGroup.addChips()


    }

    private fun initData(query:String) {
        adapter = ImagesPagingAdapter(this,viewModel.isSafeMode())
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateFooter(footer = HeaderFooterAdapter { adapter.retry() })

        binding.retryBtn.setOnClickListener {
            adapter.retry()
        }

        lifecycleScope.launch {
            viewModel.fetchImages(query).collectLatest {
                adapter.submitData(it)
            }
        }

        adapter.addLoadStateListener {
            binding.errorContainer.isVisible = it.refresh is LoadState.Error
            binding.progressView.isVisible = it.refresh is LoadState.Loading
        }
    }

    override fun onClickOpenImage(uiModel: ImageUiModel, imageView: ImageView) {
        ShowImageDialog(this,uiModel).show(parentFragmentManager,viewModel.fetchUserRecommends())
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