package com.example.exampletaxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exampletaxi.databinding.FooterLayoutBinding

class HeaderFooterAdapter(private val retry:() ->Unit): LoadStateAdapter<RecyclerView.ViewHolder>() {

    inner class LoadViewHolder(private val binding: FooterLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){

        init {
            binding.retryBtn.setOnClickListener {
                retry.invoke()
            }
        }

        fun onBind(loadState: LoadState){
            binding.progressView.isVisible = loadState is LoadState.Loading
            binding.retryBtn.isVisible = loadState is LoadState.Error
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, loadState: LoadState) {
        (holder as LoadViewHolder).onBind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): RecyclerView.ViewHolder {
        return LoadViewHolder(FooterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}