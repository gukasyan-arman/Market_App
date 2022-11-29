package com.example.data.network.api

import com.example.data.network.models.home.GoodsResponseDTO
import com.example.data.network.utils.GOODS_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface GoodsService {

    @GET(GOODS_END_POINT)
    suspend fun getAllGoods(): Response<GoodsResponseDTO>

}