package com.uz.exampletaxi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.uz.exampletaxi.databinding.FragmentSettingsBinding
import com.uz.exampletaxi.vm.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.app.AlertDialog
import com.uz.core.BaseFragment
import com.uz.exampletaxi.R
import com.uz.exampletaxi.utils.UiConstants.langs
import com.uz.exampletaxi.utils.UiConstants.recsEn
import com.uz.exampletaxi.utils.restart

@AndroidEntryPoint
class SettingsFragment :BaseFragment() {

    private lateinit var binding:FragmentSettingsBinding
    private val viewModel:SettingsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.themeSwitch.isChecked = viewModel.isDarkModelEnabled()
        binding.safeMode.isChecked = viewModel.isSafeMode()

        binding.themeSwitch.setOnCheckedChangeListener { compoundButton, _ ->
            if (compoundButton.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                viewModel.setMode(true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                viewModel.setMode(false)
            }
        }

        binding.safeMode.setOnCheckedChangeListener { compoundButton, _ ->
            viewModel.setSafeModel(compoundButton.isChecked)
            requireActivity().restart()
        }

        val recommends = resources.getStringArray(R.array.recs)
        binding.selectRecommendation.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setSingleChoiceItems(recommends, recommends.indexOf(viewModel.fetchUserRecommends()), null)
                .setPositiveButton(R.string.save) { dialog, _ ->
                    val position: Int = (dialog as AlertDialog).listView.checkedItemPosition
                    viewModel.setUserRecommends(recsEn[position])
                    dialog.dismiss()
                    requireActivity().restart()
                }.setNegativeButton(R.string.exit){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.selectLang.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setSingleChoiceItems(langs, langs.indexOf(viewModel.fetchUserLanguage()), null)
                .setPositiveButton(R.string.save) { dialog, _ ->
                    dialog.dismiss()
                    val position: Int = (dialog as AlertDialog).listView.checkedItemPosition
                    viewModel.setUserLanguage(langs[position])
                    requireActivity().restart()
                }.setNegativeButton(R.string.exit){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}