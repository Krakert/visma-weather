package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportWeatherEntity(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)