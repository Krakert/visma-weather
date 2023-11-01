package com.visma.domain.weather.model

data class WeatherForecastItem(
    val time: Long,
    val icon: String,
    val temperature: Double
)
