package com.example.exampletaxi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.BaseFragment
import com.example.domain.models.ImageDbModel
import com.example.exampletaxi.R
import com.example.exampletaxi.adapters.ImageFavoritesAdapter
import com.example.exampletaxi.databinding.FragmentFavoritesBinding
import com.example.exampletaxi.dialogs.ShowFavoriteImageDialog
import com.example.exampletaxi.utils.UiConstants.DEFAULT
import com.example.exampletaxi.utils.openBrowser
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavoritesFragment : BaseFragment(),ShowFavoriteImageDialog.CallBack,ImageFavoritesAdapter.CallBack {

    private lateinit var binding:FragmentFavoritesBinding
    private val viewModel:MainViewModel by viewModels()
    private lateinit var adapter:ImageFavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ImageFavoritesAdapter(this,viewModel.isSafeMode())
        binding.rv.layoutManager = GridLayoutManager(requireContext(),
            2,GridLayoutManager.VERTICAL,false)
        binding.rv.adapter = adapter

        lifecycleScope.launch {
            viewModel.fetchCacheImagesAsFlow().collectLatest {
                adapter.update(it)
                binding.emptyIcon.isVisible = it.isEmpty()
            }
        }
    }

    override fun onClickOpenImage(model: ImageDbModel, imageView: ImageView) {
        ShowFavoriteImageDialog(this,model).show(parentFragmentManager,DEFAULT)
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

    override fun onOpenBrowser(model: ImageDbModel) {
        requireContext().openBrowser(model.webFormat)
    }

    override fun onOpenUserPage(model: ImageDbModel) {
        requireContext().openBrowser(model.pageURL)
    }

    override fun onClickRetry() {}

    override fun onClickRemoveFavorites(model: ImageDbModel) {
        viewModel.removeCacheImage(model)
        toast(R.string.success_remove)
    }
}