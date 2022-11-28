package com.example.domain.use_cases

import com.example.domain.models.home.BestSeller
import com.example.domain.repository.GoodsRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBestSellerUseCase @Inject constructor(private val goodsRepository: GoodsRepository){
    operator fun invoke(): Flow<Resource<List<BestSeller>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = goodsRepository.getBestSeller()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting best seller!!!"))
        }
    }
}