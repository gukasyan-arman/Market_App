package com.example.domain.use_cases

import com.example.domain.models.basket.BasketResponse
import com.example.domain.repository.BasketRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBasketResponseUseCase @Inject constructor(private val basketRepository: BasketRepository) {

    operator fun invoke(): Flow<Resource<BasketResponse>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = basketRepository.getBasketResponse()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting basket!!!"))
        }
    }

}