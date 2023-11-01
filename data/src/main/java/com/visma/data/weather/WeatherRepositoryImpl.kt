package com.visma.data.weather

import com.visma.domain.weather.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor() : WeatherRepository {
    override suspend fun getWeather(): Result<Boolean> {
        TODO("Not yet implemented")
    }
}