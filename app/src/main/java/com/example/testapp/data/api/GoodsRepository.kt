package com.example.testapp.data.api

import javax.inject.Inject


class GoodsRepository @Inject constructor(private val goodsService: GoodsService) {
    suspend fun getAll() = goodsService.getAllGoods()
}