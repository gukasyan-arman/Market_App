package com.example.data.repository

import com.example.data.network.models.basket.BasketDTO
import com.example.data.network.models.basket.BasketResponseDTO

interface BasketRepository {

    suspend fun getBasketResponse(): BasketResponseDTO

    suspend fun getBasket(): List<BasketDTO>

}