package com.example.exampletaxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletaxi.adapters.ImagesPagingAdapter
import com.example.exampletaxi.databinding.ActivityMainBinding
import com.example.exampletaxi.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.exampletaxi.adapters.HeaderFooterAdapter
import com.example.exampletaxi.core.ImageUiModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ImagesPagingAdapter.CallBack {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val adapter = ImagesPagingAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter.withLoadStateHeaderAndFooter(
            HeaderFooterAdapter{adapter.retry()},HeaderFooterAdapter{adapter.retry()})

        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)
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
        val popupMenu = androidx.appcompat.widget.PopupMenu(this, view)
        popupMenu.inflate(R.menu.options_menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.downlaod -> {
                    lifecycleScope.launch {
                        val result = viewModel.saveImage(image)
                        Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
        popupMenu.show()
    }
}

