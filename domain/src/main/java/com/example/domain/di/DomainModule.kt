package com.example.domain.di

import com.example.domain.repository.DetailRepository
import com.example.domain.repository.GoodsRepository
import com.example.domain.use_cases.GetBestSellerUseCase
import com.example.domain.use_cases.GetDetailUseCase
import com.example.domain.use_cases.GetHomeStoreUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun getBestSellerUseCase(goodsRepository: GoodsRepository): GetBestSellerUseCase {
        return GetBestSellerUseCase(goodsRepository)
    }

    @Provides
    fun getHomeStoreUseCase(goodsRepository: GoodsRepository): GetHomeStoreUseCase {
        return GetHomeStoreUseCase(goodsRepository)
    }

    @Provides
    fun getDetailUseCase(detailRepository: DetailRepository): GetDetailUseCase {
        return GetDetailUseCase(detailRepository)
    }

}