package com.example.data.repository

import com.example.data.network.models.detail.DetailResponseDTO


interface DetailRepository {

    suspend fun getDetail(): DetailResponseDTO

    suspend fun getDetailImages(): List<String>

}