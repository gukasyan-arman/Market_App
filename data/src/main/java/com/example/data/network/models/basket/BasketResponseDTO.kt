package com.example.data.network.models.basket

data class BasketResponseDTO(
    val basket: List<BasketDTO>,
    val delivery: String,
    val id: String,
    val total: Int
)