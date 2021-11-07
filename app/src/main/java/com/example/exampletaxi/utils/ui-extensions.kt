package com.example.exampletaxi.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import com.example.exampletaxi.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


fun Context.openBrowser(link:String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(browserIntent)
}

fun DialogInterface.makeExpanded(){
    val dialog = this as BottomSheetDialog
    val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
    val coordinatorLayout = bottomSheet!!.parent as CoordinatorLayout
    val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
    bottomSheetBehavior.peekHeight = bottomSheet.height
    coordinatorLayout.parent.requestLayout()
}

fun View.showIfEmpty(count:Int){
    this.isVisible = count != 0
}