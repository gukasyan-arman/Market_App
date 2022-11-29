package com.example.data.repository

import com.example.data.network.api.BasketService
import com.example.data.network.models.basket.BasketDTO
import com.example.data.network.models.basket.BasketResponseDTO
import com.example.data.network.utils.SafeApiRequest
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val basketResponseService: BasketService): BasketRepository, SafeApiRequest() {

    override suspend fun getBasketResponse(): BasketResponseDTO {
        val response = safeApiRequest { basketResponseService.getBasket() }
        return response
    }

    override suspend fun getBasket(): List<BasketDTO> {
        val response = safeApiRequest { basketResponseService.getBasket() }
        return response.basket
    }

}