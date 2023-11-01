package com.visma.data.weather

import com.visma.data.component.net.KtorRequest
import com.visma.data.component.net.mapper.ResponseMapper
import com.visma.data.extension.guard
import com.visma.data.weather.api.ApiCalls
import com.visma.data.weather.mapper.WeatherForecastTodayMapper
import com.visma.data.weather.mapper.WeatherReportMapper
import com.visma.domain.weather.WeatherRepository
import com.visma.domain.weather.model.WeatherForecastToday
import com.visma.domain.weather.model.WeatherReport
import com.visma.weather.data.BuildConfig
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: KtorRequest,
    private val responseMapper: ResponseMapper,
    private val weatherReportMapper: WeatherReportMapper,
    private val weatherForecastTodayMapper: WeatherForecastTodayMapper
) : WeatherRepository {
    override suspend fun getWeatherByCity(city: String): Result<WeatherReport> {
        val response = Result.runCatching {
            api.request(
                ApiCalls.getWeatherByCity(
                    city = city,
                    apiKey = BuildConfig.API_KEY,
                )
            )
        }.guard { return it }
        val entity = responseMapper.map(response)
        return entity.mapCatching {
            weatherReportMapper.map(
                entity = it
            )
        }
    }

    override suspend fun getForecastTodayByCity(city: String): Result<WeatherForecastToday> {
        val response = Result.runCatching {
            api.request(
                ApiCalls.getWeatherForecastTodayByCity(
                    city = city,
                    apiKey = BuildConfig.API_KEY,
                )
            )
        }.guard { return it }
        val entity = responseMapper.map(response)
        return entity.mapCatching {
            weatherForecastTodayMapper.map(
                entity = it
            )
        }
    }
}