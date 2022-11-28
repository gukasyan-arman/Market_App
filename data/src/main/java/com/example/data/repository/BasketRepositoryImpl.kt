package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.api.BasketService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.models.basket.Basket
import com.example.domain.models.basket.BasketResponse
import com.example.domain.repository.BasketRepository
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val basketResponseService: BasketService): BasketRepository, SafeApiRequest() {

    override suspend fun getBasketResponse(): BasketResponse {
        val response = safeApiRequest { basketResponseService.getBasket() }
        return response.toDomain()
    }

    override suspend fun getBasket(): List<Basket> {
        val response = safeApiRequest { basketResponseService.getBasket() }
        return response.basket.toDomain()
    }

}