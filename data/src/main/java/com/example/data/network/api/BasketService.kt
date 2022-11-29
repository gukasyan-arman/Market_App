package com.example.data.network.api

import com.example.data.network.models.basket.BasketResponseDTO
import com.example.data.network.utils.BASKET_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface BasketService {

    @GET(BASKET_END_POINT)
    suspend fun getBasket(): Response<BasketResponseDTO>

}