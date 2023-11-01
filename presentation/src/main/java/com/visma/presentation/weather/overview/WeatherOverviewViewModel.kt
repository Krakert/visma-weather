package com.visma.presentation.weather.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visma.domain.weather.GetForecastByCity
import com.visma.domain.weather.GetWeatherByCity
import com.visma.presentation.ContentState
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.weather.overview.mapper.WeatherOverviewDisplayMapper
import com.visma.presentation.weather.overview.mapper.WeatherOverviewForecastDisplayMapper
import com.visma.presentation.weather.overview.model.WeatherForecastTodayDisplay
import com.visma.presentation.weather.overview.model.WeatherOverviewDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherOverviewViewModel @Inject constructor(
    private val getWeatherByCity: GetWeatherByCity,
    private val getForecastTodayByCity: GetForecastByCity,
    private val weatherOverviewDisplayMapper: WeatherOverviewDisplayMapper,
    private val weatherOverviewForecastDisplayMapper: WeatherOverviewForecastDisplayMapper,
) : ViewModel() {

    private val mutableTodayFlow = MutableStateFlow<ContentState<WeatherOverviewDisplay>>(OnLoading)
    val weatherOverviewTodayContentState: StateFlow<ContentState<WeatherOverviewDisplay>> =
        mutableTodayFlow

    private val mutableForecastFlow =
        MutableStateFlow<ContentState<WeatherForecastTodayDisplay>>(OnLoading)
    val weatherOverviewForecastToday: StateFlow<ContentState<WeatherForecastTodayDisplay>> =
        mutableForecastFlow

    private val mutableIsLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = mutableIsLoading

    init {
        fetchWeatherOverview("London")
        fetchWeatherForecast("London")
    }

    fun fetchWeatherOverview(city: String) {
        viewModelScope.launch {
            mutableIsLoading.emit(true)
            getWeatherByCity(city).onSuccess {
                mutableTodayFlow.emit(
                    OnDisplay(weatherOverviewDisplayMapper.map(it))
                )
                mutableIsLoading.emit(false)
            }.onFailure { mutableTodayFlow.emit(OnError(it)) }
        }
    }

    fun fetchWeatherForecast(city: String) {
        viewModelScope.launch {
            getForecastTodayByCity(city).onSuccess {
                mutableForecastFlow.emit(
                    OnDisplay(weatherOverviewForecastDisplayMapper.map(it))
                )
            }.onFailure { mutableTodayFlow.emit(OnError(it)) }
        }
    }
}