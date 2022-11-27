package com.example.domain.repository

import com.example.domain.models.BestSeller
import com.example.domain.models.HomeStore
import retrofit2.Response

interface GoodsRepository {

    suspend fun getBestSeller(): List<BestSeller>

    suspend fun getHomeStore(): List<HomeStore>

}