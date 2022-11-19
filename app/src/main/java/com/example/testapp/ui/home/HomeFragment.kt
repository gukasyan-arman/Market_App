package com.example.testapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapp.R
import com.example.testapp.adapters.BestSellerAdapter
import com.example.testapp.adapters.ViewPagerAdapter
import com.example.testapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel by viewModels<HomeViewModel>()
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var bestSellerAdapter: BestSellerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPagerAdapter()
        initBestSellerAdapter()

        homeViewModel.allGoods

        homeViewModel.allGoods.observe(viewLifecycleOwner) {
            it.home_store.let {
                viewPagerAdapter.differ.submitList(it)
            }
            it.best_seller.let {
                bestSellerAdapter.differ.submitList(it)
            }
        }

        initPhonesDropdown()
        initPricesDropdown()
        initSizesDropdown()

        binding.filter.setOnClickListener {
            if (binding.filterBlock.visibility == View.GONE) {
                binding.filterBlock.visibility = View.VISIBLE
            } else {
                binding.filterBlock.visibility = View.GONE
            }
        }

        binding.filterCancelBtn.setOnClickListener {
            binding.filterBlock.visibility = View.GONE
        }

        binding.filterDoneBtn.setOnClickListener {
            binding.filterBlock.visibility = View.GONE
            Toast.makeText(requireContext(), "Filters applied", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initBestSellerAdapter() {
        bestSellerAdapter = BestSellerAdapter()
        binding.bestSellerRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.bestSellerRv.adapter = bestSellerAdapter
    }

    private fun initViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPager.adapter = viewPagerAdapter
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