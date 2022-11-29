package com.example.data.repository

import com.example.data.network.models.home.BestSellerDTO
import com.example.data.network.models.home.HomeStoreDTO

interface GoodsRepository {

    suspend fun getBestSeller(): List<BestSellerDTO>

    suspend fun getHomeStore(): List<HomeStoreDTO>

}