package com.example.domain.repository

import com.example.domain.models.detail.DetailImages
import com.example.domain.models.detail.DetailResponse

interface DetailRepository {

    suspend fun getDetail(): DetailResponse

    suspend fun getDetailImages(): List<String>

}