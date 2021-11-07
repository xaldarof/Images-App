package com.example.exampletaxi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exampletaxi.adapters.FragmentController
import com.example.exampletaxi.databinding.FragmentContainerBinding


class ContainerFragment : Fragment() {

    private lateinit var binding: FragmentContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentController(
            binding,
            this,
            listOf(HomeFragment(), SearchFragment(), FavoritesFragment(), SettingsFragment()))


    }
}