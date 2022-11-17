package com.example.testapp.data.api

import com.example.testapp.models.GoodsResponse
import com.example.testapp.utils.GOODS_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface GoodsService {

    @GET(GOODS_END_POINT)
    suspend fun getAllGoods(): Response<GoodsResponse>

}