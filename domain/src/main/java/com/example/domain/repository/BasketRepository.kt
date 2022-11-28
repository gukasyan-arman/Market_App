package com.example.domain.repository

import com.example.domain.models.basket.Basket
import com.example.domain.models.basket.BasketResponse

interface BasketRepository {

    suspend fun getBasketResponse(): BasketResponse

    suspend fun getBasket(): List<Basket>

}