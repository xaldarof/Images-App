package com.uz.exampletaxi.dialogs

import android.app.Dialog
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.uz.exampletaxi.R
import com.uz.exampletaxi.core.ImageUiModel
import com.uz.exampletaxi.databinding.FragmentViewImageBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.exampletaxi.utils.makeExpanded
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShowImageDialog(private val callBack:CallBack ,
                      private val uiModel: ImageUiModel) : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentViewImageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.setOnShowListener { it.makeExpanded() }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        binding = FragmentViewImageBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)

        binding.authorName.text = uiModel.user
        binding.views.text = uiModel.views.toString()

        setUpImages(uiModel.largeImageURL,binding.largeImage)
        setUpImages(uiModel.userImageURL,binding.userAvatarImage)
        setUpClicks()

        return dialog
    }


    private fun setUpImages(url:String,img:ImageView){
        Glide.with(requireContext())
            .load(url)
            .error(R.drawable.ic_baseline_signal_wifi_bad_24)
            .into(img)
    }

    private fun setUpClicks(){
        binding.shareBtn.setOnClickListener { callBack.onShare(binding.largeImage) }
        binding.saveBtn.setOnClickListener { callBack.onSave(binding.largeImage) }
        binding.openBrowserBtn.setOnClickListener { callBack.onOpenBrowser(uiModel) }
        binding.userAvatarCardView.setOnClickListener { callBack.onOpenUserPage(uiModel) }
        binding.exitBtn.setOnClickListener { dismiss() }
        binding.addFavoritesBtn.setOnClickListener { callBack.onClickAddFavorites(uiModel) }
        binding.setWallpaperBtn.setOnClickListener { callBack.onClickSetWallpaper(binding.largeImage) }
    }

    interface CallBack {
        fun onShare(imageView: ImageView)
        fun onSave(imageView: ImageView)
        fun onOpenBrowser(uiModel: ImageUiModel)
        fun onOpenUserPage(uiModel: ImageUiModel)
        fun onClickRetry()
        fun onClickAddFavorites(uiModel: ImageUiModel)
        fun onClickSetWallpaper(imageView: ImageView)
    }
}