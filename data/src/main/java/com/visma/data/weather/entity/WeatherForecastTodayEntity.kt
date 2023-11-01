package com.visma.data.weather.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastTodayEntity(
    val cnt: Int?,
    val cod: String?,
    val list: List<WeatherForecastItemEntity>?,
    val message: Int?
)


