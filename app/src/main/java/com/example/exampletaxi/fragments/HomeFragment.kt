package com.example.exampletaxi.fragments

import android.os.Bundle
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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletaxi.R
import com.example.exampletaxi.adapters.HeaderFooterAdapter
import com.example.exampletaxi.adapters.ImagesPagingAdapter
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentHomeBinding
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(),ImagesPagingAdapter.CallBack {

    private lateinit var binding:FragmentHomeBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ImagesPagingAdapter(this)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateHeaderAndFooter(
            HeaderFooterAdapter{adapter.retry()}, HeaderFooterAdapter{adapter.retry()})

        val dividerItemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.rv.addItemDecoration(dividerItemDecoration)


        lifecycleScope.launch {
            viewModel.fetchImages().collectLatest {
                adapter.submitData(it)
            }
        }

        adapter.addLoadStateListener {
            binding.errorIcon.isVisible = it.refresh is LoadState.Error
        }
    }

    override fun onClickOptions(uiModel: ImageUiModel, view: View, image: ImageView) {
        val popupMenu = androidx.appcompat.widget.PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.options_menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.downlaod -> {
                    lifecycleScope.launch {
                        val result = viewModel.saveImage(image)
                        Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
        popupMenu.show()
    }
}