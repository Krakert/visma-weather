package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportLocationEntity(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)