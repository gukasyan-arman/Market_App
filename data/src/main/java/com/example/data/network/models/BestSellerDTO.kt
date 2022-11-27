package com.example.data.network.models

import com.example.domain.models.BestSeller

data class BestSellerDTO(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
){
    fun toBestSellers() = BestSeller(discount_price, id, is_favorites, picture, price_without_discount, title)
}