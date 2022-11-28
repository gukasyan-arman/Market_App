package com.example.domain.use_cases

import com.example.domain.models.basket.Basket
import com.example.domain.repository.BasketRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBasketUseCase @Inject constructor(private val basketRepository: BasketRepository) {

    operator fun invoke(): Flow<Resource<List<Basket>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = basketRepository.getBasket()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting basket!!!"))
        }
    }

}