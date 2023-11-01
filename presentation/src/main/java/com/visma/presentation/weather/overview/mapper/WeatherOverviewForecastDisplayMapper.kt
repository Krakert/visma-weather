package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherForecast
import com.visma.presentation.weather.overview.model.WeatherForecast24hDisplay
import javax.inject.Inject

class WeatherOverviewForecastDisplayMapper @Inject constructor(
    private val weatherOverviewForecastItemDisplayMapper: WeatherOverviewForecastItemDisplayMapper
) {
    fun map(weatherForecastToday: WeatherForecast): WeatherForecast24hDisplay {
        return WeatherForecast24hDisplay(
            result = weatherForecastToday.result.map {
                weatherOverviewForecastItemDisplayMapper.map(it)
            }
        )
    }

}
