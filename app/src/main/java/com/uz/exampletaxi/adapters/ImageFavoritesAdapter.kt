package com.uz.exampletaxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uz.domain.models.ImageDbModel
import com.uz.exampletaxi.R
import com.uz.exampletaxi.databinding.CacheImageItemBinding

class ImageFavoritesAdapter(private val callBack: CallBack,private val isSafeMode:Boolean):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val oldList = ArrayList<ImageDbModel>()

    fun update(newList:List<ImageDbModel>){
        oldList.clear()
        oldList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(private val binding: CacheImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(imageDbModel: ImageDbModel) {

            Glide.with(binding.root.context)
                .load(if (isSafeMode) imageDbModel.previewURL else imageDbModel.webFormat)
                .placeholder(R.drawable.ic_baseline_arrow_downward_24)
                .into(binding.image)

            binding.image.setOnClickListener {
                callBack.onClickOpenImage(imageDbModel,binding.image)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).onBind(oldList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(
            CacheImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun notifyChanged(){
        notifyDataSetChanged()
    }

    interface CallBack {
        fun onClickOpenImage(model: ImageDbModel,imageView: ImageView)
    }

    override fun getItemCount(): Int  = oldList.size
}