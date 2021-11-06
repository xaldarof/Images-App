package com.example.exampletaxi.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exampletaxi.R
import com.example.exampletaxi.databinding.FragmentHomeBinding
import com.example.exampletaxi.databinding.FragmentViewImageBinding


class ViewImageFragment : Fragment() {

    private lateinit var binding:FragmentViewImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewImageBinding.inflate(inflater,container,false)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}