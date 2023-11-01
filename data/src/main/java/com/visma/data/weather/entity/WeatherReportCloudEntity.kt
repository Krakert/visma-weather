package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportCloudEntity(
    val all: Int
)