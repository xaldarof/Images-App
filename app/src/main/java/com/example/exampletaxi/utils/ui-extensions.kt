package com.example.exampletaxi.utils

import android.content.Context
import android.content.Intent
import android.net.Uri


fun Context.openBrowser(link:String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(browserIntent)
}