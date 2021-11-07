package com.example.exampletaxi.adapters

import android.annotation.SuppressLint
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.exampletaxi.R
import com.example.exampletaxi.databinding.FragmentContainerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

@SuppressLint("UseCompatLoadingForDrawables")
class FragmentController(
    private val binding: FragmentContainerBinding,
    fragment:Fragment,
    fragments: List<Fragment>) : ViewPager2.OnPageChangeCallback(){


    private var fragmentAdapter: FragmentAdapter =
        FragmentAdapter(fragment.childFragmentManager, fragment.lifecycle, fragments)


    init {
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.adapter = fragmentAdapter
        binding.pager.offscreenPageLimit = fragmentAdapter.itemCount
        val context = binding.root.context

        for (i in fragments.indices) {
            binding.tabLayout.getTabAt(i)?.icon?.setTint(ContextCompat.getColor(context,R.color.light_black))
        }

        binding.pager.apply {
            registerOnPageChangeCallback(this@FragmentController)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab!!.icon?.setTint(ContextCompat.getColor(context,R.color.black))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab!!.icon?.setTint(ContextCompat.getColor(context,R.color.light_black))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.icon = ContextCompat.getDrawable(binding.root.context,
                        R.drawable.ic_baseline_border_all_24)
                }

                1 -> {
                    tab.icon =  ContextCompat.getDrawable(binding.root.context,
                        R.drawable.ic_baseline_search_24)
                }

                2 -> {
                    tab.icon =  ContextCompat.getDrawable(binding.root.context,
                        R.drawable.ic_baseline_favorite_24)
                }

                3 -> {
                    tab.icon =  ContextCompat.getDrawable(binding.root.context,
                        R.drawable.ic_baseline_star_24)
                }
            }

        }.attach()
    }
}