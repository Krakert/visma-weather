package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherReport
import com.visma.presentation.weather.overview.formatter.DegreeFormatter
import com.visma.presentation.weather.overview.model.WeatherOverviewDisplay
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherOverviewDisplayMapper @Inject constructor(
    private val degreeFormatter: DegreeFormatter
) {
    fun map (weather: WeatherReport): WeatherOverviewDisplay {
        return WeatherOverviewDisplay(
            temperature = degreeFormatter.map(weather.temperature.roundToInt().toString()),
            icon = weather.icon,
            description = weather.description
        )
    }

}
