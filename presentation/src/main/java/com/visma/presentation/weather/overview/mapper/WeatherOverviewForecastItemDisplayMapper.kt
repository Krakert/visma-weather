package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherForecastItem
import com.visma.presentation.weather.formatter.DegreeFormatter
import com.visma.presentation.weather.formatter.UnixTimeToHourStampFormatter
import com.visma.presentation.weather.model.WeatherForecastItemDisplay
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherOverviewForecastItemDisplayMapper @Inject constructor(
    private val unixTimeToHourStampFormatter: UnixTimeToHourStampFormatter,
    private val degreeFormatter: DegreeFormatter
) {
    fun map(item: WeatherForecastItem): WeatherForecastItemDisplay {
        return WeatherForecastItemDisplay(
            time = unixTimeToHourStampFormatter.map(item.time),
            icon = item.icon,
            temperature = degreeFormatter.map(item.temperature.roundToInt().toString())
        )
    }

}
