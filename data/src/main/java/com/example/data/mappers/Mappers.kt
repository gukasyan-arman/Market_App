package com.example.data.mappers

import com.example.data.network.models.detail.DetailResponseDTO
import com.example.data.network.models.home.BestSellerDTO
import com.example.data.network.models.home.HomeStoreDTO
import com.example.domain.models.detail.DetailResponse
import com.example.domain.models.home.BestSeller
import com.example.domain.models.home.HomeStore

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

fun DetailResponseDTO.toDomain(): DetailResponse {
    return DetailResponse(
        CPU = CPU,
        camera = camera,
        capacity = capacity,
        color = color,
        id = id,
        images = images,
        isFavorites = isFavorites,
        price = price,
        rating = rating,
        sd = sd,
        ssd = ssd,
        title = title
    )
}