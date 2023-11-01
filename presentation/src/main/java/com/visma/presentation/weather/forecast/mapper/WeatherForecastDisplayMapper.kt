package com.visma.presentation.weather.forecast.mapper

import com.visma.domain.weather.model.WeatherForecast
import com.visma.domain.weather.model.WeatherForecastItem
import com.visma.presentation.weather.forecast.model.WeatherForecastListDisplay
import com.visma.presentation.weather.forecast.model.WeatherForecastListItemDisplay
import com.visma.presentation.weather.formatter.DegreeFormatter
import com.visma.presentation.weather.formatter.UnixTimeToHourStampFormatter
import com.visma.presentation.weather.model.WeatherForecastItemDisplay
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherForecastDisplayMapper @Inject constructor(
    private val degreeFormatter: DegreeFormatter,
    private val unixTimeToHourStampFormatter: UnixTimeToHourStampFormatter
) {
    fun map(weatherForecast: WeatherForecast): WeatherForecastListDisplay {
        val dateFormat = SimpleDateFormat("EEE d MMM")

        val forecastMap = mutableMapOf<String, MutableList<WeatherForecastItem>>()

        for (forecastItem in weatherForecast.result) {
            val date = Date(forecastItem.time * 1000L)
            val dateKey = dateFormat.format(date)

            val dateList = forecastMap.getOrPut(dateKey) { mutableListOf() }
            dateList.add(forecastItem)
        }

        return WeatherForecastListDisplay(result = forecastMap.map { (date, forecastItems) ->
            WeatherForecastListItemDisplay(date = date,
                forecasts = forecastItems.map { forecastItem ->
                    WeatherForecastItemDisplay(
                        time = unixTimeToHourStampFormatter.map(forecastItem.time),
                        icon = forecastItem.icon,
                        temperature = degreeFormatter.map(forecastItem.temperature.roundToInt().toString())
                    )
                })
        })
    }

}
