package com.example.domain.di

import com.example.data.repository.BasketRepository
import com.example.data.repository.DetailRepository
import com.example.data.repository.GoodsRepository
import com.example.domain.use_cases.*
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

    @Provides
    fun getDetailImagesUseCase(detailRepository: DetailRepository): GetDetailImagesUseCase {
        return GetDetailImagesUseCase(detailRepository)
    }

    @Provides
    fun getBasketResponseUseCase(basketRepository: BasketRepository): GetBasketResponseUseCase {
        return GetBasketResponseUseCase(basketRepository)
    }

    @Provides
    fun getBasketUseCase(basketRepository: BasketRepository): GetBasketUseCase {
        return GetBasketUseCase(basketRepository)
    }

}