package com.example.testapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.api.GoodsRepository
import com.example.testapp.models.GoodsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: GoodsRepository): ViewModel(){
    private val _allGoods = MutableLiveData<GoodsResponse>()
    val allGoods: LiveData<GoodsResponse>
        get() = _allGoods

    init {
        getAll()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll().let {
            if (it.isSuccessful) {
                _allGoods.postValue(it.body())
            } else {
                Log.d("checkData", "Failed to load ${it.errorBody()}")
            }
        }
    }
}