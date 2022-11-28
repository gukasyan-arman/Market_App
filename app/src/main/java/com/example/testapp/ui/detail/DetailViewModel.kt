package com.example.testapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.detail.DetailResponse
import com.example.domain.use_cases.GetDetailUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase): ViewModel() {

    private val _detailResponse = MutableLiveData<DetailResponse>()
    val detailResponse: LiveData<DetailResponse>
        get() = _detailResponse

    init {
        getDetailResponse()
    }

    fun getDetailResponse() {
        getDetailUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    Log.d("getBestSeller", "Loading")
                }
                is Resource.Success -> {
                    _detailResponse.value = it.data!!
                }
                is Resource.Error -> {
                    Log.e("getBestSeller", "some error")
                }
            }
        }.launchIn(viewModelScope)
    }

}