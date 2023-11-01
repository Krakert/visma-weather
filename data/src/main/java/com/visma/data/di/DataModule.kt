package com.visma.data.di

import com.visma.data.weather.WeatherRepositoryImpl
import com.visma.domain.weather.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindWeatherRepository(repository: WeatherRepositoryImpl): WeatherRepository

}