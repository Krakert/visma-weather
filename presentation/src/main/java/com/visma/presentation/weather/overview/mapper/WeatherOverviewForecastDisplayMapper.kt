package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherForecastToday
import com.visma.presentation.weather.overview.model.WeatherForecastTodayDisplay
import javax.inject.Inject

class WeatherOverviewForecastDisplayMapper @Inject constructor(
    private val weatherOverviewForecastItemDisplayMapper: WeatherOverviewForecastItemDisplayMapper
) {
    fun map(weatherForecastToday: WeatherForecastToday): WeatherForecastTodayDisplay {
        return WeatherForecastTodayDisplay(
            result = weatherForecastToday.result.map {
                weatherOverviewForecastItemDisplayMapper.map(it)
            }
        )
    }

}
