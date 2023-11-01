package com.visma.domain.weather

interface WeatherRepository {

    suspend fun getWeather(): Result<Boolean>
}