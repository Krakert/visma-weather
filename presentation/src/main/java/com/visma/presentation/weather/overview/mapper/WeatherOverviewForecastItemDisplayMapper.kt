package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherForecastTodayItem
import com.visma.presentation.weather.overview.formatter.DegreeFormatter
import com.visma.presentation.weather.overview.formatter.UnixTimeToHourStampFormatter
import com.visma.presentation.weather.overview.model.WeatherForecastTodayItemDisplay
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherOverviewForecastItemDisplayMapper @Inject constructor(
    private val unixTimeToHourStampFormatter: UnixTimeToHourStampFormatter,
    private val degreeFormatter: DegreeFormatter
) {
    fun map(item: WeatherForecastTodayItem): WeatherForecastTodayItemDisplay {
        return WeatherForecastTodayItemDisplay(
            time = unixTimeToHourStampFormatter.map(item.time),
            icon = item.icon,
            temperature = degreeFormatter.map(item.temperature.roundToInt().toString())
        )
    }

}
