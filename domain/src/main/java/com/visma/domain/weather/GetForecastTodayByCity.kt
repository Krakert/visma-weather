package com.visma.domain.weather

import com.visma.domain.weather.model.WeatherForecastToday
import javax.inject.Inject

class GetForecastTodayByCity @Inject constructor(
    private val repository: WeatherRepository,
) {
    suspend operator fun invoke(city: String): Result<WeatherForecastToday> =
        repository.getForecastTodayByCity(city)
}