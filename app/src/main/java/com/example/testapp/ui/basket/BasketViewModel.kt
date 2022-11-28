package com.example.testapp.ui.basket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.basket.Basket
import com.example.domain.models.basket.BasketResponse
import com.example.domain.use_cases.GetBasketResponseUseCase
import com.example.domain.use_cases.GetBasketUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val getBasketResponseUseCase: GetBasketResponseUseCase,
    private val getBasketUseCase: GetBasketUseCase): ViewModel(){

    private val _basketResponse = MutableLiveData<BasketResponse>()
    val basketResponse: LiveData<BasketResponse>
        get() = _basketResponse

    private val _basket = MutableLiveData<List<Basket>>()
    val basket: LiveData<List<Basket>>
        get() = _basket

    init {
        getBasketResponse()
        getBasket()
    }

    private fun getBasketResponse() {
        getBasketResponseUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    Log.d("getBasket", "Loading")
                }
                is Resource.Success -> {
                    _basketResponse.value = it.data!!
                }
                is Resource.Error -> {
                    Log.e("getBasket", "some error")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getBasket() {
        getBasketUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    Log.d("getBasket", "Loading")
                }
                is Resource.Success -> {
                    _basket.value = it.data!!
                }
                is Resource.Error -> {
                    Log.e("getBasket", "some error")
                }
            }
        }.launchIn(viewModelScope)
    }



}