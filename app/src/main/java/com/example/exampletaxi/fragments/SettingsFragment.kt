package com.example.exampletaxi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.example.exampletaxi.databinding.FragmentSettingsBinding
import com.example.exampletaxi.vm.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.app.AlertDialog
import com.example.exampletaxi.R
import com.example.exampletaxi.utils.UiConstants.langs
import com.example.exampletaxi.utils.restart


@AndroidEntryPoint
class SettingsFragment : Fragment() {

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

        binding.themeSwitch.setOnCheckedChangeListener { compoundButton, _ ->
            if (compoundButton.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                viewModel.setMode(true)
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                viewModel.setMode(false)
            }
        }

        val recommends = resources.getStringArray(R.array.recs)
        binding.selectRecommendation.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setSingleChoiceItems(recommends, recommends.indexOf(viewModel.fetchUserRecommends()), null)
                .setPositiveButton(R.string.save) { dialog, _ ->
                    dialog.dismiss()
                    val position: Int = (dialog as AlertDialog).listView.checkedItemPosition
                    viewModel.setUserRecommends(recommends[position])
                    requireActivity().restart()
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
                }
                .show()
        }
    }
}