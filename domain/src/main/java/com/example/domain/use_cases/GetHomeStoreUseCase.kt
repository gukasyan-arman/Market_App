package com.example.domain.use_cases

import com.example.domain.models.home.HomeStore
import com.example.domain.repository.GoodsRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeStoreUseCase @Inject constructor(private val goodsRepository: GoodsRepository){
    operator fun invoke(): Flow<Resource<List<HomeStore>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = goodsRepository.getHomeStore()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting home store!!!"))
        }
    }
}