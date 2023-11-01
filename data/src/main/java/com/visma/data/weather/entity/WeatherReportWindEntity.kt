package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherReportWindEntity(
    val deg: Int?,
    val gust: Double? = null,
    val speed: Double?
)