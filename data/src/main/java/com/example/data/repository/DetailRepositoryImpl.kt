package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.api.DetailService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.models.detail.DetailResponse
import com.example.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(private val detailService: DetailService): DetailRepository, SafeApiRequest() {

    override suspend fun getDetail(): DetailResponse {
        val response = safeApiRequest { detailService.getDetail() }
        return response.toDomain()
    }

}