package com.example.exampletaxi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.BaseFragment
import com.example.exampletaxi.databinding.FragmentViewImageBinding


class ViewImageFragment : BaseFragment() {

    private lateinit var binding:FragmentViewImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentViewImageBinding.inflate(inflater,container,false)
        return binding.root
    }
}