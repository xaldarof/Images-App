package com.example.exampletaxi.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exampletaxi.adapters.HeaderFooterAdapter
import com.example.exampletaxi.adapters.ImagesPagingAdapter
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentSearchBinding
import com.example.exampletaxi.utils.CallBack
import com.example.exampletaxi.utils.CustomTextChangedListener
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(),ImagesPagingAdapter.CallBack {

    private lateinit var binding:FragmentSearchBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ImagesPagingAdapter(this)

        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateFooter(footer = HeaderFooterAdapter{adapter.retry()})

        adapter.addLoadStateListener {
            binding.errorIcon.isVisible = it.refresh is LoadState.Error
        }

        binding.searchView.addTextChangedListener(CustomTextChangedListener(object :CallBack{
            override fun afterChanged(p0: Editable?) {
                lifecycleScope.launch {
                    viewModel.fetchImages(p0.toString()).distinctUntilChanged().collectLatest {
                        adapter.submitData(it)
                    }
                }
            }
        }))
    }


    override fun onClickOpenImage(uiModel: ImageUiModel, imageView: ImageView) {

    }
}