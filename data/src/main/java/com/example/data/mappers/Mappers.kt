package com.example.data.mappers

import com.example.data.network.models.BestSellerDTO
import com.example.data.network.models.HomeStoreDTO
import com.example.domain.models.BestSeller
import com.example.domain.models.HomeStore

@JvmName("toDomainBestSellerDTO")
fun List<BestSellerDTO>.toDomain(): List<BestSeller> {
    return map {
        BestSeller (
            discount_price = it.discount_price,
            id = it.id,
            is_favorites = it.is_favorites,
            picture = it.picture,
            price_without_discount = it.price_without_discount,
            title = it.title
        )
    }
}

fun List<HomeStoreDTO>.toDomain(): List<HomeStore> {
    return map {
        HomeStore (
            id = it.id,
            is_buy = it.is_buy,
            is_new = it.is_new,
            picture = it.picture,
            subtitle = it.subtitle,
            title = it.title
        )
    }
}