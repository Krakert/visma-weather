package com.visma.domain.weather

import com.visma.domain.weather.model.WeatherForecastToday
import javax.inject.Inject

class GetForecastByCity @Inject constructor(
    private val repository: WeatherRepository,
) {
    suspend operator fun invoke(city: String): Result<WeatherForecastToday> =
        repository.getForecastByCity(city)
}