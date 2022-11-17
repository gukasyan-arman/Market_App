package com.example.testapp.models

data class GoodsResponse(
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)