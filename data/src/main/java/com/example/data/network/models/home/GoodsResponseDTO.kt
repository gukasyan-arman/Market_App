package com.example.data.network.models.home

data class GoodsResponseDTO(
    val best_seller: List<BestSellerDTO>,
    val home_store: List<HomeStoreDTO>
)