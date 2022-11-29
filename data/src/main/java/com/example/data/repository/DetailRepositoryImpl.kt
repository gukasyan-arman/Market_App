package com.example.data.repository

import com.example.data.network.api.DetailService
import com.example.data.network.models.detail.DetailResponseDTO
import com.example.data.network.utils.SafeApiRequest
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(private val detailService: DetailService): DetailRepository, SafeApiRequest() {
    override suspend fun getDetail(): DetailResponseDTO {
        val response = safeApiRequest { detailService.getDetail() }
        return response
    }

    override suspend fun getDetailImages(): List<String> {
        val response = safeApiRequest { detailService.getDetail() }
        return response.images
    }
}