package com.example.data.di

import com.example.data.network.api.GoodsService
import com.example.data.repository.GoodsRepositoryImpl
import com.example.domain.repository.GoodsRepository
import com.example.domain.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun logging() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(logging())
        .build()

    @Provides
    @Singleton
    fun provideAllGoodsService(baseUrl: String): GoodsService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(GoodsService:: class.java)

    @Provides
    fun provideGoodsRepository(goodsService: GoodsService): GoodsRepository {
        return GoodsRepositoryImpl(goodsService = goodsService)
    }
}