package com.example.domain.models.home

data class GoodsResponse(
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)