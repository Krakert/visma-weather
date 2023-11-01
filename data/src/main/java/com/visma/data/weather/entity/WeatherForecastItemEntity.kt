package com.visma.data.weather.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastItemEntity(
    val clouds: WeatherReportCloudEntity?,
    val dt: Long?,
    @SerialName("dt_txt") val dtTxt: String?,
    val main: WeatherReportMainEntity?,
    val pop: Double?,
    val rain: WeatherForecastRainEntity? = null,
    val visibility: Int?,
    val weather: List<WeatherReportWeatherEntity>?,
    val wind: WeatherReportWindEntity?
)