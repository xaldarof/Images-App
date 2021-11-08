package com.example.exampletaxi.utils

import android.content.res.Resources
import com.example.exampletaxi.R

object UiConstants {
    const val DEFAULT = "life"
    const val NOTHING = "!-1-K1!#KP"

    val recommends = arrayOf(
        Resources.getSystem().getString(R.string.life),
        Resources.getSystem().getString(R.string.love),
        Resources.getSystem().getString(R.string.sport),
        Resources.getSystem().getString(R.string.girls),
        Resources.getSystem().getString(R.string.boys),
        Resources.getSystem().getString(R.string.football),
        Resources.getSystem().getString(R.string.tech),
    )
    val langs = arrayOf("uz", "ru", "en")
}