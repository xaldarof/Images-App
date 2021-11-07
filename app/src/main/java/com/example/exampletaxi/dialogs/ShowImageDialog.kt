package com.example.exampletaxi.dialogs

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.exampletaxi.R
import com.example.exampletaxi.core.ImageUiModel
import com.example.exampletaxi.databinding.FragmentViewImageBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.exampletaxi.databinding.ErrorLayoutBinding
import com.example.exampletaxi.utils.makeExpanded
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShowImageDialog(private val callBack:CallBack ,
                      private val uiModel: ImageUiModel) :
    BottomSheetDialogFragment() {

    private lateinit var binding:FragmentViewImageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.setOnShowListener { it.makeExpanded() }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.attributes?.windowAnimations = R.style.DialogAnimation
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
            .error(R.drawable.ic_baseline_person_24)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                          isFirstResource: Boolean): Boolean {
                    Toast.makeText(requireContext(), R.string.no_connection, Toast.LENGTH_SHORT).show()
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?,
                                             dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false
                }
            })
            .into(img)
    }

    private fun setUpClicks(){
        binding.shareBtn.setOnClickListener { callBack.onShare(binding.largeImage) }
        binding.saveBtn.setOnClickListener { callBack.onSave(binding.largeImage) }
        binding.openBrowserBtn.setOnClickListener { callBack.onOpenBrowser(uiModel) }
        binding.userAvatarCardView.setOnClickListener { callBack.onOpenUserPage(uiModel) }
        binding.exitBtn.setOnClickListener { dismiss() }
        binding.addFavoritesBtn.setOnClickListener { callBack.onClickAddFavorites(uiModel) }
    }

    interface CallBack {
        fun onShare(imageView: ImageView)
        fun onSave(imageView: ImageView)
        fun onOpenBrowser(uiModel: ImageUiModel)
        fun onOpenUserPage(uiModel: ImageUiModel)
        fun onClickRetry()
        fun onClickAddFavorites(uiModel: ImageUiModel)
    }
}