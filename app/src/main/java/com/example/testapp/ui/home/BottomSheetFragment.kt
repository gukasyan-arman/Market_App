package com.example.testapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPhonesDropdown()
        initPricesDropdown()
        initSizesDropdown()

        binding.filterCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.filterDoneBtn.setOnClickListener {
            Toast.makeText(context, "Filters applied", Toast.LENGTH_SHORT).show()
            dismiss()
        }

    }

    private fun initPhonesDropdown() {
        val phones = resources.getStringArray(R.array.phones)
        val phonesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, phones)
        binding.autoCompletePhone.setAdapter(phonesAdapter)
    }

    private fun initPricesDropdown() {
        val prices = resources.getStringArray(R.array.prices)
        val pricesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, prices)
        binding.autoCompletePrices.setAdapter(pricesAdapter)
    }

    private fun initSizesDropdown() {
        val sizes = resources.getStringArray(R.array.sizes)
        val sizesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, sizes)
        binding.autoCompleteSizes.setAdapter(sizesAdapter)
    }
}