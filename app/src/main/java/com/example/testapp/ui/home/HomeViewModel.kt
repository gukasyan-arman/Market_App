package com.example.testapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.home.BestSeller
import com.example.domain.models.home.HomeStore
import com.example.domain.use_cases.GetBestSellerUseCase
import com.example.domain.use_cases.GetHomeStoreUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBestSellerUseCase: GetBestSellerUseCase,
    private val getHomeStoreUseCase: GetHomeStoreUseCase
): ViewModel() {

    private val _bestSeller = MutableLiveData<List<BestSeller>>()
    val bestSeller: LiveData<List<BestSeller>>
        get() = _bestSeller

    private val _homeStore = MutableLiveData<List<HomeStore>>()
    val homeStore: LiveData<List<HomeStore>>
        get() = _homeStore

    init {
        getBestSeller()
        getHomeStore()
    }

        private fun getBestSeller() {
            getBestSellerUseCase().onEach {
                when(it) {
                    is Resource.Loading -> {
                        Log.d("getBestSeller", "Loading")
                    }
                    is Resource.Success -> {
                        _bestSeller.value = it.data!!
                    }
                    is Resource.Error -> {
                        Log.e("getBestSeller", "some error")
                    }
                }
            }.launchIn(viewModelScope)
        }

    private fun getHomeStore() {
            getHomeStoreUseCase().onEach {
                when(it) {
                    is Resource.Loading -> {
                        Log.d("getHomeStore", "Loading")
                    }
                    is Resource.Success -> {
                        _homeStore.value = it.data!!
                    }
                    is Resource.Error -> {
                        Log.e("getHomeStore", "some error")
                    }
                }
            }.launchIn(viewModelScope)
        }
}