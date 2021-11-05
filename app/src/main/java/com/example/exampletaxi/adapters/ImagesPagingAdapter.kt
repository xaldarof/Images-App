package com.example.exampletaxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.ImageItemBinding

class ImagesPagingAdapter : PagingDataAdapter<ImageUiModel,RecyclerView.ViewHolder>(Comparator) {


    inner class ImageViewHolder(private val binding:ImageItemBinding):RecyclerView.ViewHolder(binding.root){

        fun onBind(imageUiModel: ImageUiModel) {

            Glide.with(binding.root.context)
                .load(imageUiModel.previewURL)
                .into(binding.image)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { (holder as ImageViewHolder).onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    object Comparator : DiffUtil.ItemCallback<ImageUiModel>() {

        override fun areItemsTheSame(oldItem: ImageUiModel, newItem: ImageUiModel): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageUiModel, newItem: ImageUiModel): Boolean {
            return oldItem == newItem
        }

    }
}