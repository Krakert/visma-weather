package com.visma.domain.weather

import com.visma.domain.weather.model.WeatherReport
import javax.inject.Inject

class GetWeatherByCity @Inject constructor(
    private val repository: WeatherRepository,
) {
    suspend operator fun invoke(city: String): Result<WeatherReport> = repository.getWeatherByCity(city)
}