package com.example.data.network.models

import com.example.domain.models.HomeStore

data class HomeStoreDTO(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
){
    fun toHomeStores() = HomeStore(id, is_buy, is_new, picture, subtitle, title)
}