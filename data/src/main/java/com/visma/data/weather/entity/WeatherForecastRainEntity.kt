package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastRainEntity(
    val `3h`: Double?
)