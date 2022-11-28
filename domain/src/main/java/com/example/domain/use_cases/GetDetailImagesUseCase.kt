package com.example.domain.use_cases

import com.example.domain.models.detail.DetailImages
import com.example.domain.repository.DetailRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailImagesUseCase @Inject constructor(private val detailRepository: DetailRepository) {

    operator fun invoke(): Flow<Resource<List<String>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = detailRepository.getDetailImages()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error("Error getting detail images!!!"))
        }
    }

}