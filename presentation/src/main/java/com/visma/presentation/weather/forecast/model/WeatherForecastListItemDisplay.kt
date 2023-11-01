package com.visma.presentation.weather.forecast.model

data class WeatherForecastListItemDisplay(
    val date: String,
    val forecasts: List<WeatherForecastItemDisplay>
)
