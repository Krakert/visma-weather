package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportEntity(
    val base: String?,
    val clouds: WeatherReportCloudEntity?,
    val cod: Int?,
    val coord: WeatherReportCoordinationEntity?,
    val dt: Long?,
    val id: Int?,
    val main: WeatherReportMainEntity?,
    val name: String?,
    val sys: WeatherReportLocationEntity?,
    val timezone: Int?,
    val visibility: Int?,
    val weather: List<WeatherReportWeatherEntity>?,
    val wind: WeatherReportWindEntity?
)