package com.visma.data.weather.mapper

import com.visma.data.extension.requireNotNull
import com.visma.data.weather.entity.WeatherForecastTodayEntity
import com.visma.domain.weather.model.WeatherForecast
import javax.inject.Inject

class WeatherForecastTodayMapper @Inject constructor(
    private val weatherForecastTodayItemMapper: WeatherForecastTodayItemMapper
) {
    fun map(entity: WeatherForecastTodayEntity): WeatherForecast {
        return WeatherForecast(
            result = entity.list?.map {
                weatherForecastTodayItemMapper.map(it)
            }.requireNotNull()
        )
    }
}
