package com.example.testapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapp.R
import com.example.testapp.ui.adapters.BestSellerAdapter
import com.example.testapp.ui.adapters.CategoryItemAdapter
import com.example.testapp.ui.adapters.HomeViewPagerAdapter
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.models.CategoryItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), BestSellerAdapter.Listener {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel by viewModels<HomeViewModel>()

    private lateinit var viewPagerAdapter: HomeViewPagerAdapter
    private lateinit var bestSellerAdapter: BestSellerAdapter
    private lateinit var categoryItemAdapter: CategoryItemAdapter
    private val categoryItemsList = listOf(
        CategoryItem(R.drawable.ic_phone, "Phones", false),
        CategoryItem(R.drawable.ic_computer, "Computers", false),
        CategoryItem(R.drawable.ic_health, "Healths", false),
        CategoryItem(R.drawable.ic_books, "Books", false),
    )

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
        initCategoryItemAdapter()

        homeViewModel.bestSeller.observe(viewLifecycleOwner) {
            bestSellerAdapter.differ.submitList(it)
        }

        homeViewModel.homeStore.observe(viewLifecycleOwner) {
            viewPagerAdapter.differ.submitList(it)
        }

        binding.filter.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bottomSheetFragment)
        }

    }

    private fun initBestSellerAdapter() {
        bestSellerAdapter = BestSellerAdapter(this)
        binding.bestSellerRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.bestSellerRv.adapter = bestSellerAdapter
    }

    private fun initCategoryItemAdapter() {
        categoryItemAdapter = CategoryItemAdapter(categoryItemsList) {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
        binding.categoryButtonsRv.adapter = categoryItemAdapter

    }

    private fun initViewPagerAdapter() {
        viewPagerAdapter = HomeViewPagerAdapter()
        binding.viewPager.adapter = viewPagerAdapter
    }

    override fun onClick() {
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

}