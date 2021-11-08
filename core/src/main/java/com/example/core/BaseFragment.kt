package com.example.core

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.core.Constants.TAG

abstract class BaseFragment : Fragment(){


    fun logd(message:String){
        Log.d(TAG,message)
    }

    fun toast(id: Int){
        Toast.makeText(requireContext(),id,Toast.LENGTH_SHORT).show()
    }


}