package com.uz.exampletaxi.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.uz.exampletaxi.MainActivity
import com.uz.exampletaxi.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun Context.requestStoragePermission(){
    ActivityCompat.requestPermissions(this as Activity,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
        1)
}

fun Context.openBrowser(link: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(browserIntent)
}

fun DialogInterface.makeExpanded() {
    val dialog = this as BottomSheetDialog
    val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
    val coordinatorLayout = bottomSheet!!.parent as CoordinatorLayout
    val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
    bottomSheetBehavior.peekHeight = bottomSheet.height
    coordinatorLayout.parent.requestLayout()
}

fun View.showIfEmpty(count: Int) {
    this.isVisible = count != 0
}

fun ChipGroup.addChips(){
    UiConstants.chip_names.forEachIndexed { index, s ->
        val chip = Chip(this.context)
        chip.text = s
        chip.checkedIcon = ContextCompat.getDrawable(this.context, R.drawable.ic_baseline_search_24)
        chip.text = UiConstants.chip_names[index]
        chip.isCheckable = true
        addView(chip)
    }

}

fun Activity.restart() {
    finish()
    startActivity(Intent(this, MainActivity::class.java))
}