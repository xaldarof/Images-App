package com.example.exampletaxi.dialogs

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.exampletaxi.R
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentViewImageBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.content.Intent
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.startActivity
import java.io.FileNotFoundException
import java.io.InputStream


class ShowImageDialog(context: Context, private val uiModel: ImageUiModel) :
    BottomSheetDialog(context, R.style.BottomSheetDialogTheme) {


    fun showDialog(callBack: CallBack) {
        val binding = FragmentViewImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.attributes?.windowAnimations = R.style.DialogAnimation

        Glide.with(context)
            .load(uiModel.largeImageURL)
            .into(binding.largeImage)
        Log.d("res", "DIALOG = ${uiModel.largeImageURL}")

        Glide.with(context)
            .load(uiModel.userImageURL)
            .into(binding.userAvatarImage)

        binding.shareBtn.setOnClickListener { callBack.onShare(binding.largeImage) }
        binding.saveBtn.setOnClickListener { callBack.onSave(binding.largeImage) }
        binding.openBrowserBtn.setOnClickListener { callBack.onOpenBrowser(uiModel) }

        show()
    }

    interface CallBack {
        fun onShare(imageView: ImageView)
        fun onSave(imageView: ImageView)
        fun onOpenBrowser(uiModel: ImageUiModel)
    }
}