package com.example.android.navigation

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.FragmentGameWonBinding
import com.example.android.navigation.databinding.FragmentSettingsBinding
private lateinit var binding: FragmentSettingsBinding
class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        ArrayAdapter.createFromResource(
                requireActivity().getBaseContext(),
                R.array.languages_array,
                android.R.layout.simple_spinner_item
        ).also{adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.languageSpinner.adapter = adapter
        }
        binding.languageSpinner.onItemSelectedListener = SpinnerActivity()
        return binding.root
    }
}

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

        binding.languageSelectedText.text = parent.getItemAtPosition(pos).toString()
        binding.languageSelectedText.visibility = View.VISIBLE
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        binding.languageSelectedText.text = "Please, select something"
    }
}
