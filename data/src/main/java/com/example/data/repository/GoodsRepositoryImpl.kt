package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.api.GoodsService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.models.BestSeller
import com.example.domain.models.HomeStore
import com.example.domain.repository.GoodsRepository
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(private val goodsService: GoodsService): GoodsRepository, SafeApiRequest() {

    override suspend fun getBestSeller(): List<BestSeller> {
        val response = safeApiRequest { goodsService.getAllGoods() }
        return response.best_seller.toDomain()
    }

    override suspend fun getHomeStore(): List<HomeStore> {
        val response = safeApiRequest { goodsService.getAllGoods() }
        return response.home_store.toDomain()
    }

}