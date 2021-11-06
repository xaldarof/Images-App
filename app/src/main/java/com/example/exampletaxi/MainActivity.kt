package com.example.exampletaxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exampletaxi.adapters.FragmentController
import com.example.exampletaxi.databinding.ActivityMainBinding
import com.example.exampletaxi.fragments.HomeFragment
import com.example.exampletaxi.fragments.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
}

