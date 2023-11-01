package com.visma.data.weather.mapper

import com.visma.data.extension.requireNotNull
import com.visma.data.weather.entity.WeatherForecastItemEntity
import com.visma.domain.weather.model.WeatherForecastItem
import javax.inject.Inject

class WeatherForecastTodayItemMapper @Inject constructor(
    private val iconMapper: WeatherIconMapper
) {
    fun map(weatherReportEntity: WeatherForecastItemEntity): WeatherForecastItem {
        return WeatherForecastItem(
            time = weatherReportEntity.dt.requireNotNull(),
            icon = iconMapper.getIconUrl(weatherReportEntity.weather?.get(0)?.icon.requireNotNull()),
            temperature = weatherReportEntity.main?.temp.requireNotNull()
        )
    }
}
