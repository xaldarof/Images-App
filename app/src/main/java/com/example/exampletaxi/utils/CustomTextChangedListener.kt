package com.example.exampletaxi.utils

import android.text.Editable
import android.text.TextWatcher

interface CallBack {
    fun afterChanged(p0: Editable?)
}

class CustomTextChangedListener(private val callBack: CallBack): TextWatcher {

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {
        callBack.afterChanged(p0)
    }
}