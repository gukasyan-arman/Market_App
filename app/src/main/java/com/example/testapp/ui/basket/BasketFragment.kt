package com.example.testapp.ui.basket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.databinding.FragmentBasketBinding
import com.example.testapp.ui.adapters.BasketAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : Fragment() {

    private lateinit var binding: FragmentBasketBinding
    private val basketViewModel by viewModels<BasketViewModel>()
    private lateinit var basketAdapter: BasketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.basketBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_basketFragment_to_detailFragment)
        }

        initAdapter()

        basketViewModel.basket.observe(viewLifecycleOwner) {
            basketAdapter.differ.submitList(it)
        }

        basketViewModel.basketResponse.observe(viewLifecycleOwner) {basket ->
            binding.deliveryPrice.text = basket.delivery
            binding.totalPrice.text = "$${basket.total}"
        }

    }

    private fun initAdapter(){
        basketAdapter = BasketAdapter()
        binding.basketItemRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.basketItemRv.adapter = basketAdapter
    }

}