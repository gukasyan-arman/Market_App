package com.example.testapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.detail.DetailImages
import com.example.domain.models.detail.DetailResponse
import com.example.domain.use_cases.GetDetailImagesUseCase
import com.example.domain.use_cases.GetDetailUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase,
    private val getDetailImagesUseCase: GetDetailImagesUseCase,
): ViewModel() {

    private val _detailResponse = MutableLiveData<DetailResponse>()
    val detailResponse: LiveData<DetailResponse>
        get() = _detailResponse

    private val _detailImages = MutableLiveData<List<String>>()
    val detailImages: LiveData<List<String>>
        get() = _detailImages

    init {
        getDetailResponse()
//        getDetailImages()
    }

    fun getDetailResponse() {
        getDetailUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    Log.d("getDetail", "Loading")
                }
                is Resource.Success -> {
                    _detailResponse.value = it.data!!
                }
                is Resource.Error -> {
                    Log.e("getDetail", "some error")
                }
            }
        }.launchIn(viewModelScope)

        getDetailImagesUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    Log.d("getDetail", "Loading")
                }
                is Resource.Success -> {
                    _detailImages.value = it.data!!
                }
                is Resource.Error -> {
                    Log.e("getDetail", "some error")
                }
            }
        }.launchIn(viewModelScope)
    }

//    fun getDetailImages() {
//        getDetailImagesUseCase().onEach {
//            when(it) {
//                is Resource.Loading -> {
//                    Log.d("getDetail", "Loading")
//                }
//                is Resource.Success -> {
//                    _detailImages.value = it.data!!
//                }
//                is Resource.Error -> {
//                    Log.e("getDetail", "some error")
//                }
//            }
//        }.launchIn(viewModelScope)
//    }

}