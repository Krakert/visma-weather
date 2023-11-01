package com.visma.presentation.weather.overview.mapper

import com.visma.domain.weather.model.WeatherReport
import com.visma.presentation.weather.overview.model.WeatherOverviewDisplay
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherOverviewDisplayMapper @Inject constructor() {
    fun map (weather: WeatherReport): WeatherOverviewDisplay {
        return WeatherOverviewDisplay(
            temperature = weather.temperature.roundToInt().toString(),
            icon = weather.icon,
            description = weather.description
        )
    }

}
