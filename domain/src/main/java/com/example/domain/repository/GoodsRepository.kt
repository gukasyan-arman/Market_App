package com.example.domain.repository

import com.example.domain.models.home.BestSeller
import com.example.domain.models.home.HomeStore

interface GoodsRepository {

    suspend fun getBestSeller(): List<BestSeller>

    suspend fun getHomeStore(): List<HomeStore>

}