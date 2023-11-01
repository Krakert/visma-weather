package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportCoordinationEntity(
    val lat: Double,
    val lon: Double
)