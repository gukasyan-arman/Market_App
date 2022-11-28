package com.example.testapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.databinding.FragmentDetailBinding
import com.example.testapp.ui.adapters.DetailViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()
    private lateinit var viewPagerAdapter: DetailViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPagerAdapter()

        detailViewModel.detailImages.observe(viewLifecycleOwner) {
            viewPagerAdapter.differ.submitList(it)
        }

        detailViewModel.detailResponse.observe(viewLifecycleOwner) {
            binding.cpText.text = it.CPU
            binding.cameraText.text = it.camera
            binding.hardMemoryText.text = it.sd
            binding.operativeMemoryText.text = it.ssd
            binding.detailPriceProduct.text = "$${it.price}"
            binding.detailTitle.text = it.title
        }

        binding.detailBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }

        binding.detailBasketButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_basketFragment)
        }

    }

    private fun initViewPagerAdapter() {
        viewPagerAdapter = DetailViewPagerAdapter()
        binding.detailViewPager.adapter = viewPagerAdapter
    }

}
