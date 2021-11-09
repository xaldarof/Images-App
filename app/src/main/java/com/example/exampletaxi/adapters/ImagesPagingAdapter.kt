package com.example.exampletaxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.exampletaxi.R
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.ImageItemBinding
import android.util.TypedValue




class ImagesPagingAdapter(private val callBack: CallBack,private val isSafeMode:Boolean)
    : PagingDataAdapter<ImageUiModel, RecyclerView.ViewHolder>(Comparator) {


    inner class ImageViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(imageUiModel: ImageUiModel) {

            Glide.with(binding.root.context)
                .load(if (isSafeMode) imageUiModel.previewURL else imageUiModel.webFormat)
                .placeholder(R.drawable.ic_baseline_arrow_downward_24)
                .into(binding.image)

            binding.image.setOnClickListener {
                callBack.onClickOpenImage(imageUiModel,binding.image)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { (holder as ImageViewHolder).onBind(it) }

        if (position == 1 || position == 0) {
            val tv = TypedValue()

            if (holder.itemView.context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                val actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
                    holder.itemView.context.resources.displayMetrics)

                val params = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                params.topMargin = actionBarHeight
                holder.itemView.layoutParams = params
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(ImageItemBinding
            .inflate(LayoutInflater
            .from(parent.context),
            parent, false)
        )
    }

    object Comparator : DiffUtil.ItemCallback<ImageUiModel>() {

        override fun areItemsTheSame(oldItem: ImageUiModel, newItem: ImageUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageUiModel, newItem: ImageUiModel): Boolean {
            return oldItem == newItem
        }
    }

    interface CallBack {
        fun onClickOpenImage(uiModel: ImageUiModel,imageView: ImageView)
    }
}