package com.example.data.network.api

import com.example.data.network.models.detail.DetailResponseDTO
import com.example.data.network.utils.DETAIL_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface DetailService {

    @GET(DETAIL_END_POINT)
    suspend fun getDetail(): Response<DetailResponseDTO>

}