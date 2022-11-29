package com.example.data.repository

import com.example.data.network.api.GoodsService
import com.example.data.network.models.home.BestSellerDTO
import com.example.data.network.models.home.HomeStoreDTO
import com.example.data.network.utils.SafeApiRequest
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(private val goodsService: GoodsService): GoodsRepository, SafeApiRequest() {

    override suspend fun getBestSeller(): List<BestSellerDTO> {
        val response = safeApiRequest { goodsService.getAllGoods() }
        return response.best_seller
    }

    override suspend fun getHomeStore(): List<HomeStoreDTO> {
        val response = safeApiRequest { goodsService.getAllGoods() }
        return response.home_store
    }

}