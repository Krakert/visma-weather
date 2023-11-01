package com.visma.domain.weather

import com.visma.domain.weather.model.WeatherForecast
import javax.inject.Inject

class GetForecastByCity @Inject constructor(
    private val repository: WeatherRepository,
) {
    suspend operator fun invoke(city: String, cnt: Int): Result<WeatherForecast> =
        repository.getForecastByCity(city, cnt)
}