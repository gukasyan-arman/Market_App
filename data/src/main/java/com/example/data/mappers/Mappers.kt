package com.example.data.mappers

import com.example.data.network.models.basket.BasketDTO
import com.example.data.network.models.basket.BasketResponseDTO
import com.example.data.network.models.detail.DetailImagesDTO
import com.example.data.network.models.detail.DetailResponseDTO
import com.example.data.network.models.home.BestSellerDTO
import com.example.data.network.models.home.HomeStoreDTO
import com.example.domain.models.basket.Basket
import com.example.domain.models.basket.BasketResponse
import com.example.domain.models.detail.DetailImages
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

@JvmName("toDomainHomeStoreDTO")
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

fun BasketResponseDTO.toDomain(): BasketResponse {
    return BasketResponse(
        basket = basket.toDomain(),
        delivery = delivery,
        id = id,
        total = total,
    )
}

@JvmName("toDomainBasketDTO")
fun List<BasketDTO>.toDomain(): List<Basket> {
    return map {
        Basket (
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title,
        )
    }
}

@JvmName("toDomainDetailImagesDTO")
fun List<DetailImagesDTO>.toDomain(): List<DetailImages> {
    return map {
        DetailImages (
            imageUrl = it.imageUrl
        )
    }
}