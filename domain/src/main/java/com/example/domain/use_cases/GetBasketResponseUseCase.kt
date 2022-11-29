package com.example.domain.use_cases

import com.example.data.repository.BasketRepository
import com.example.domain.models.basket.BasketResponse
import com.example.domain.models.mapper.toDomain
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBasketResponseUseCase @Inject constructor(private val basketRepository: BasketRepository) {

    operator fun invoke(): Flow<Resource<BasketResponse>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = basketRepository.getBasketResponse().toDomain()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting basket!!!"))
        }
    }

}