package com.visma.data.weather.api

import com.visma.data.component.net.model.ApiMethod
import com.visma.data.component.net.model.ApiRequest
import com.visma.data.component.net.model.Query
import com.visma.data.weather.entity.WeatherReportEntity

object ApiCalls {

    fun getWeatherByCity(
        city: String,
        apiKey: String,
        unit: String = "metric",
    ) = ApiRequest<WeatherReportEntity>(
        method = ApiMethod.GET,
        path = "weather",
        parameters = listOf(
            Query("q", city),
            Query("appid", apiKey),
            Query("units", unit),
        )
    )
}