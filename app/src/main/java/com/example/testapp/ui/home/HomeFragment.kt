package com.example.testapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapp.adapters.BestSellerAdapter
import com.example.testapp.adapters.ViewPagerAdapter
import com.example.testapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

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

}