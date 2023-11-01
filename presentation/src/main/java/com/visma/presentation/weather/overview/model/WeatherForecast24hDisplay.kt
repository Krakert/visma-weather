package com.visma.presentation.weather.overview.model

import com.visma.presentation.weather.model.WeatherForecastItemDisplay

data class WeatherForecast24hDisplay(
    val result: List<WeatherForecastItemDisplay>
)