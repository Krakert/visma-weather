package com.visma.domain.weather

import com.visma.domain.weather.model.WeatherForecast
import com.visma.domain.weather.model.WeatherReport

interface WeatherRepository {

    suspend fun getWeatherByCity(city: String): Result<WeatherReport>
    suspend fun getForecastByCity(city: String, cnt: Int): Result<WeatherForecast>
}