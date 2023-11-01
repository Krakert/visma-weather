package com.visma.presentation.weather.forecast.model

import com.visma.presentation.weather.model.WeatherForecastItemDisplay

data class WeatherForecastListItemDisplay(
    val date: String,
    val forecasts: List<WeatherForecastItemDisplay>
)
