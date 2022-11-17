package com.example.testapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.testapp.R
import com.example.testapp.adapters.ViewPagerAdapter
import com.example.testapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private val homeViewModel by viewModels<HomeViewModel>()
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        homeViewModel.allGoods

        homeViewModel.allGoods.observe(viewLifecycleOwner) {
            it.home_store.let {
                viewPagerAdapter.differ.submitList(it)
            }
        }

    }

    private fun initAdapter() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPager.adapter = viewPagerAdapter
    }

}