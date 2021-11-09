package com.example.exampletaxi.utils

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import com.example.exampletaxi.MainActivity
import com.example.exampletaxi.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

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

fun Activity.restart() {
    finish()
    startActivity(Intent(this, MainActivity::class.java))
}

fun String.defineRecommend(): String {
    if (this == "Жизнь") return "Life"
    if (this == "Любовь") return "Love"
    if (this == "Спорт") return "Sport"
    if (this == "Девушки") return "Girls"
    if (this == "Мальчики") return "Boys"
    if (this == "Футбол") return "Football"
    if (this == "Технологии") return "Technology"
    if (this == "Роботы") return "Robots"
    if (this == "Кошки") return "Cats"
    if (this == "Животные") return "Animals"
    if (this == "Собаки") return "Dogs"
    if (this == "Грусть") return "Sad"
    if (this == "Мотивация") return "Motivation"
    if (this == "Дружба") return "Friend"
    if (this == "Магия") return "Magic"

    return "Life"
}
