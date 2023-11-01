package com.visma.domain.weather.model

import java.util.Date

data class WeatherReport(
    val temperature: Double,
    val description: String,
    val date: Date,
    val icon: String,
)