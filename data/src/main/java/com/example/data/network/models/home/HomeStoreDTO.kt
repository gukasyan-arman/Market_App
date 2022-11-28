package com.example.data.network.models.home

data class HomeStoreDTO(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)