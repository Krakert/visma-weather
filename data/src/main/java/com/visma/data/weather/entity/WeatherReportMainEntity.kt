package com.visma.data.weather.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportMainEntity(
    @SerialName("feels_like") val feelsLike: Double?,
    val humidity: Int?,
    val pressure: Int?,
    val temp: Double?,
    @SerialName("temp_max") val tempMax: Double?,
    @SerialName("temp_min") val tempMin: Double?
)