package com.example.domain.models.basket

data class BasketResponse(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)