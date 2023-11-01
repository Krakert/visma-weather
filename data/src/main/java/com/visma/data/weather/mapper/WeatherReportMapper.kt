package com.visma.data.weather.mapper

import com.visma.data.extension.requireNotNull
import com.visma.data.weather.entity.WeatherReportEntity
import com.visma.domain.weather.model.WeatherReport
import java.util.Date
import javax.inject.Inject

class WeatherReportMapper @Inject constructor(
    private val weatherIconMapper: WeatherIconMapper
) {
    fun map(entity: WeatherReportEntity): WeatherReport {
        return WeatherReport(
            temperature = entity.main?.temp.requireNotNull(),
            description = entity.weather?.get(0)?.description.requireNotNull(),
            date = Date(entity.dt.requireNotNull()).requireNotNull(),
            icon = entity.weather?.get(0)?.icon?.let { weatherIconMapper.getIconUrl(it) }.requireNotNull()
        )
    }
}